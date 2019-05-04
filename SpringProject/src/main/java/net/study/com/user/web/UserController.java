package net.study.com.user.web;


import com.fasterxml.jackson.databind.ObjectMapper;
import net.study.com.user.commons.GoogleAuth;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.social.google.connect.GoogleOAuth2Template;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping(value = "/login")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private GoogleAuth googleAuth;

    @Autowired
    private GoogleOAuth2Template googleOAuth2Template;

    @Autowired
    private OAuth2Parameters googleOAuth2Parameters;

    // 로그인 페이지
    @RequestMapping(value = "/googleLogin", method = { RequestMethod.GET, RequestMethod.POST })
    public String join(Model model) {

        // 인증할 url
        String url = googleOAuth2Template.buildAuthenticateUrl(GrantType.AUTHORIZATION_CODE, googleOAuth2Parameters);

        model.addAttribute("google_url", url);

        logger.info("구글 로그인 url: "+ url);

        return "/user/login";
    }

    // 구글로그인
    @RequestMapping(value = "/googleSignInCallback")
    public String doSessionAssignActionPage(HttpServletRequest request) throws Exception {

        // 로그인을 통해 받은 코드 값
        String code = request.getParameter("code");
        logger.info("구글 로그인 code: "+ code);


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
         */


        return "/home";

    }

}
