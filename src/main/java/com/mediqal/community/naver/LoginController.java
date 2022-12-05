package com.mediqal.community.naver;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/naver/*")
@Slf4j
public class LoginController {

    /* NaverLoginBO */
    private NaverLoginBO naverLoginBO;
    private String apiResult = null;

    @Autowired
    private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
        this.naverLoginBO = naverLoginBO;
    }

    @GetMapping("/login")
    public void login() {
        log.info("home controller");
    }
    @GetMapping("/naverSuccess")
    public void naverSuccess(HttpSession session) {
        log.info("callback controller");
    }
}
//    @GetMapping("/login")
//    public String login(Model model, HttpSession session) {
//        log.info("home controller");
//
//        /* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
//        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
//
//        //https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
//        //redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
//        System.out.println("네이버:" + naverAuthUrl);
//
//        //네이버
//        model.addAttribute("url", naverAuthUrl);
//
//        /* 생성한 인증 URL을 View로 전달 */
//        return "login";
//    }
//
//    @GetMapping("/naverSuccess")
//    public String naverSuccess(Model model, @RequestParam String code, @RequestParam String state, HttpSession session) throws IOException {
//        log.info("callback controller");
//        System.out.println("여기는 callback");
//        OAuth2AccessToken oauthToken;
//        oauthToken = naverLoginBO.getAccessToken(session, code, state);
//        //로그인 사용자 정보를 읽어온다.
//        apiResult = naverLoginBO.getUserProfile(oauthToken);
//        model.addAttribute("result", apiResult);
//
//        /* 네이버 로그인 성공 페이지 View 호출 */
//        return "naverSuccess";
//
//    }
//}


//@Controller
//@RequestMapping("/naver/*")
//@Slf4j
//public class LoginController {
//
//    @GetMapping("/login")
//    public void login() {
//        log.info("home controller");
//    }
//
//    @GetMapping("/naverSuccess")
//    public void naverSuccess(HttpSession session) {
//        log.info("callback controller");
//    }
//}