package net.study.com.user.web;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.study.com.user.commons.SocialLogin;
import net.study.com.user.domain.User;
import net.study.com.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.google.connect.GoogleOAuth2Template;
import org.springframework.social.oauth2.GrantType;
import org.springframework.social.oauth2.OAuth2Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value = "/login")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private GoogleOAuth2Template googleOAuth2Template;

    @Autowired
    private OAuth2Parameters googleOAuth2Parameters;

    @Autowired
    private UserService userService;


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
    public String doSessionAssignActionPage(HttpServletRequest request, HttpSession session) throws Exception {

        // 로그인을 통해 받은 코드 값
        String code = request.getParameter("code");
        logger.info("구글 로그인 code: "+ code);

        SocialLogin socialLogin = new SocialLogin();

        Map<String, String> result = socialLogin.getGoogleAccessToken(code);


        String userId  = result.get("sub");

        boolean userCheck = userService.userCheck(userId);


        if(!userCheck){
            logger.info("기존의 회원정보가 없으므로 회원가입 진행합니다.");

            // 회원 등록
            userService.registerUser(result, "GOOGLE");

            User loginUser = userService.getUserByUserId(userId);

            session.setAttribute("loginId", loginUser.getLogin_id());
            session.setAttribute("nickName", loginUser.getUser_nickname());

        }else {
            User loginUser = userService.getUserByUserId(userId);

            //기존에 있는 회원이므로 바로 로그인 진행
            logger.info("기존의 회원정보가 존재합니다. ", loginUser);

            session.setAttribute("loginId", loginUser.getLogin_id());
            session.setAttribute("nickName", loginUser.getUser_nickname());

        }

        return "/home";

    }


    // 카카오 로그인
    @RequestMapping(value = "/oauth", produces = "application/json")
    public String kakaoLogin(@RequestParam("code") String code, Model model, HttpSession session) throws Exception{

        SocialLogin socialLogin = new SocialLogin();


        JsonNode KakaoAccessTokenJson = socialLogin.getKakaoAccessToken(code);

        //노드 안에 있는 access_token값을 꺼내 문자열로 변환
        String token = KakaoAccessTokenJson.get("access_token").toString();

        JsonNode kakaoProfileJson =  socialLogin.getKakaoUserProfile(token);

        ObjectMapper mapper = new ObjectMapper();

        Map<String, Object> result = mapper.readValue(kakaoProfileJson.toString(), Map.class);

        String userId  = result.get("id").toString();

        boolean userCheck = userService.userCheck(userId);


        if(!userCheck){
            logger.info("기존의 회원정보가 없으므로 회원가입 진행합니다.");

            // 회원 등록
            userService.registerUser(result, "KAKAO");

            User loginUser = userService.getUserByUserId(userId);

            session.setAttribute("loginId", loginUser.getLogin_id());
            session.setAttribute("nickName", loginUser.getUser_nickname());


        }else {
            User loginUser = userService.getUserByUserId(userId);

            //기존에 있는 회원이므로 바로 로그인 진행
            logger.info("기존의 회원정보가 존재합니다. ", loginUser);

            session.setAttribute("loginId", loginUser.getLogin_id());
            session.setAttribute("nickName", loginUser.getUser_nickname());

        }

        return "/home";
    }



    //로그아웃
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        session.invalidate();

        return "/home";

    }

}
