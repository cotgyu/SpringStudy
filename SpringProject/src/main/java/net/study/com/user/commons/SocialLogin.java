package net.study.com.user.commons;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SocialLogin {

    private static final Logger logger = LoggerFactory.getLogger(SocialLogin.class);

    @Autowired
    private GoogleAuth googleAuth;


    @Autowired
    private OAuth2Parameters googleOAuth2Parameters;



    //카카오로부터 AccessToken 받기
    public JsonNode getKakaoAccessToken(String autorize_code) {

        final String RequestUrl = "https://kauth.kakao.com/oauth/token";

        final List<NameValuePair> postParams = new ArrayList<NameValuePair>();

        //포스트 파라미터의 grant_type이라는 명칭에 authorization_code를 추가한다 아래도 동일
        postParams.add(new BasicNameValuePair("grant_type", "authorization_code"));

        postParams.add(new BasicNameValuePair("client_id", "4c6dceb5eb1855fff0a634bdb04459aa"));

        postParams.add(new BasicNameValuePair("redirect_uri", "http://localhost:8080/login/oauth")); //예 : http://아이피:포트/최상위폴더/리다이렉션경로

        postParams.add(new BasicNameValuePair("code", autorize_code));

        final HttpClient client = HttpClientBuilder.create().build();

        final HttpPost post = new HttpPost(RequestUrl);

        JsonNode returnNode = null;

        try {

            post.setEntity(new UrlEncodedFormEntity(postParams));

            final HttpResponse response = client.execute(post);

            ObjectMapper mapper = new ObjectMapper();

            returnNode = mapper.readTree(response.getEntity().getContent());

        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();

        } catch (ClientProtocolException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

        }

        return returnNode;

    }

    // 받은 토큰을 통해 카카오로 부터 사용자 프로필 받기
    public JsonNode getKakaoUserProfile(String autorize_code) {

        final String RequestUrl = "https://kapi.kakao.com/v1/user/me";

        final HttpClient client = HttpClientBuilder.create().build();
        final HttpPost post = new HttpPost(RequestUrl);

        post.addHeader("Authorization", "Bearer " + autorize_code);

        JsonNode returnNode = null;

        try {
            final HttpResponse response = client.execute(post);

            ObjectMapper mapper = new ObjectMapper();
            returnNode = mapper.readTree(response.getEntity().getContent());

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // clear resources
        }

        return returnNode;

    }

    public Map getGoogleAccessToken(String code) throws Exception{


        // 구글로그인을 통해 받은 정보로 access token 얻기
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> parameters = new LinkedMultiValueMap<>();
        parameters.add("code", code);
        parameters.add("client_id", googleAuth.getClientId());
        parameters.add("client_secret", googleAuth.getClientSecret());
        parameters.add("redirect_uri", googleOAuth2Parameters.getRedirectUri());
        parameters.add("grant_type", "authorization_code");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<MultiValueMap<String, String>>(parameters, headers);
        ResponseEntity<Map> responseEntity = restTemplate.exchange("https://www.googleapis.com/oauth2/v4/token", HttpMethod.POST, requestEntity, Map.class);
        Map<String, Object> responseMap = responseEntity.getBody();


        String[] tokens = ((String)responseMap.get("id_token")).split("\\.");
        Base64 base64 = new Base64(true);
        String body = new String(base64.decode(tokens[1]));

        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> result = mapper.readValue(body, Map.class);

        logger.info("구글에서 받은 값: "+ result);

        logger.info("사용자인증 ID : "+ result.get("sub"));


        /*
        넘어온 json 값들 설명
        https://developers.google.com/identity/protocols/OpenIDConnect

        iss : 로그인 구분 값
        sub : userId
         */

        return result;
    }


}
