package com.mediqal.community.controller;

import com.mediqal.community.domain.dto.UserDTO;
import com.mediqal.community.domain.vo.UserVO;
import com.mediqal.community.service.SignUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Controller
@RequestMapping("/user/*")
@Slf4j
public class UserController {

    @Qualifier("sign")
    private final SignUserService signUserService;

    public UserController(SignUserService signUserService) {
        this.signUserService = signUserService;
    }


    //    회원가입
    @GetMapping("/signup")
    public void signup(Model model){
        model.addAttribute("user", new UserDTO());
    }
    //    public void signup(){
//        log.info("signup 실행");
//    }

    @PostMapping
        public RedirectView signup(UserDTO userDTO, RedirectAttributes redirectAttributes, HttpServletRequest req){
        signUserService.signUp(userDTO);
        redirectAttributes.addFlashAttribute("userNumber", userDTO.getUserNumber());
        req.getSession().invalidate();
        return new RedirectView("/user/signin");
    }
//        public RedirectView signup(UserDTO userDTO){
//        signUserService.signUp(userDTO);
//        return new RedirectView("/user/signin");
//    }


    //    로그인
    @GetMapping("/signin")
    public void signin(Model model){
        model.addAttribute("user", new UserDTO());
    }

    @PostMapping("/signin")
    public RedirectView signin(HttpServletRequest request, Model model, String userEmail, String userPassword) {
//        세션에 유저 정보 담기?
        HttpSession session = request.getSession();
        log.info(userEmail + userPassword);
        Long userNumber = null;
        try {
            userNumber = signUserService.login(userEmail, userPassword);
            session.setAttribute("userNumber", userNumber);
            return new RedirectView("/main/index?login=ok");
        } catch (Exception e) {
            System.out.println("로그인 실패");
            return new RedirectView("/user/signin?check=false");
        }
    }

    
//    로그아웃
    @GetMapping("/signout")
    public String signout(HttpServletRequest request) throws Exception{
        request.getSession().removeAttribute("userNumber");
        request.getSession(true);
        request.getSession().invalidate();
        return "redirect:/main/index?login=x";
    }

//    아이디 중복체크
    @PostMapping("/idCheck")
    @ResponseBody
    public int idCheck(@RequestParam("userEmail") String userEmail){
        int cnt = signUserService.checkId(userEmail);
        return cnt;
    }

//    닉네임 중복체크
    @PostMapping("/nicknameCheck")
    @ResponseBody
    public int nicknameCheck(@RequestParam("userNickname") String userNickname){
        int cnt2 = signUserService.checkNickname(userNickname);
        return cnt2;
    }

//    카카오 로그인
    @GetMapping("/kakao")
    @ResponseBody
    public RedirectView kakaoLogin(@RequestParam String code, HttpSession session, Model model){
        UserVO userVO = new UserVO();

        //        System.out.println(code);
        String access_Token = signUserService.getKaKaoAccessToken(code);
        HashMap<String, Object> userInfo = signUserService.getUserInfo(access_Token);
        System.out.println("login Controller : " + userInfo);

        if (userInfo.get("email") != null){
            session.setAttribute("userEmail", userInfo.get("email"));
            session.setAttribute("userName", userInfo.get("nickname"));
            session.setAttribute("access_Token", access_Token);
//            System.out.println(((String) session.getAttribute("userEmail")));  /*잘가져오는지 체크용*/
        }
/*        userVO.setUserEmail((String) session.getAttribute("userEmail"));
        userVO.setUserPassword("kakao");
        userVO.setUserAuthType("kakao");*/
        System.out.println("카카오 컨트롤러");
        /*카카오에서 가져온 userEmail과 회원가입 되어있는 userEmail이 중복이 없을 경우(비회원)*/
        if (signUserService.checkId((String) session.getAttribute("userEmail")) == 0){
            System.out.println("비회원");
            userVO.setUserEmail((String) session.getAttribute("userEmail"));
            userVO.setUserPassword("kakao");
            userVO.setUserAuthType("kakao");
//            userVO.setUserName(session.getAttribute());
            model.addAttribute("user", userVO);
            session.setAttribute("user", userVO);
            session.setAttribute("userEmail", (String) session.getAttribute("userEmail"));
            session.setAttribute("userAuthType", "kakao");
            System.out.println(session.getAttribute("userEmail"));
            return new RedirectView("/user/signup");
//            return new RedirectView("/user/signup?user="+userVO);
        } else {    /*카카오에서 가져온 userEmail과 회원가입 되어있는 userEmail이 중복될 경우(이미 회원인 경우)*/
            System.out.println("회원");
            String userEmail = (String)(session.getAttribute("userEmail"));
            long userNumber = signUserService.login(userEmail, "kakao");

            session.setAttribute("userNumber", userNumber);
            return new RedirectView("/main/index?login=ok");
        }
    }
//    @GetMapping("/kakao")
//    @ResponseBody
//    public void kakaoLogin(@RequestParam String code){
////        System.out.println(code);
//        String access_Token = signUserService.getKaKaoAccessToken(code);
//        HashMap<String, Object> userInfo = signUserService.getUserInfo(access_Token);
//        System.out.println("login Controller : " + userInfo);
//
//    }

//   네이버 로그인
//    @GetMapping("/naverSuccess")
//    public void naverSuccess(HttpSession session) {
//        log.info("callback controller");
//    }

//    @GetMapping("/")
//    public void login() {
//        log.info("home controller");
//    }
//
//    @GetMapping("/naverSuccess")
//    public void naverSuccess(HttpSession session) {
//        log.info("callback controller");
//    }
/* NaverLoginBO */
//private NaverLoginBO naverLoginBO;
//    private String apiResult = null;
//
//    @Autowired
//    private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
//        this.naverLoginBO = naverLoginBO;
//    }
//
//    @GetMapping("/naver")
//    public RedirectView naverLogin(Model model, HttpSession session) {
//        UserVO userVO = new UserVO();
//        log.info("네이버");
//        System.out.println(naverLoginBO.getAuthorizationUrl(session));
//
//        /* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
//        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
//        //https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
//        //redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
//        System.out.println("네이버:" + naverAuthUrl);
//
//        //네이버
//        model.addAttribute("url", naverAuthUrl);
//
//        /* 생성한 인증 URL을 View로 전달 */
//        return new RedirectView("/user/signup")
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

    @GetMapping("/naverLogin")
    public void naverLogin(HttpSession session, Model model){
        System.out.println("네이버 로그인 컨트롤러 들어옴");
        UserVO userVO = new UserVO();
        userVO.setUserEmail("userEmail");

        System.out.println(userVO.getUserEmail());
//        userVO.setUserEmail("userEmail");
//        userVO.setUserEmail("userEmail");
//
//        /*네이버 로그인한 회원의 이메일이 이미 있는 이메일이라면 바로 로그인 아니라면 회원가입창으로 이동*/
//        if (){
//            System.out.println("회원");
//            String userEmail = ;
//            long userNumber = signUserService.login(userEmail, "naver");
//
//            session.setAttribute("userNumber", userNumber);
//            return new RedirectView("/main/index?login=ok");
//        }else{
//            System.out.println("비회원");
//
//            userVO.setUserEmail();
//            userVO.setUserName();
//            userVO.setUserAuthType("naver");
//            userVO.setUserPassword("naver");
//
//            session.setAttribute("userNaver", userVO);
//            session.setAttribute("userPassword", "naver");
//            session.setAttribute("userName", );
//            session.setAttribute("userAuthType", "naver");
//
//            return new RedirectView("/user/signup");
////            return new RedirectView("/user/signup?auth=naver");
//        }

//        return new RedirectView("/user/naver");
    }



//    비밀번호 찾기

    @GetMapping("/article")
    public void article(){ log.info("article 실행"); }

    @GetMapping("/email")
    public void email(){ log.info("email 실행"); }

    @GetMapping("/info")
    public void info(){ log.info("info 실행"); }

    @GetMapping("/leave")
    public void leave(){ log.info("leave 실행"); }

    @GetMapping("/notification")
    public void notification(){ log.info("leave 실행"); }

    @GetMapping("/password")
    public void password(){ log.info("password 실행"); }

    @GetMapping("/reply")
    public void reply(){ log.info("leave 실행"); }

    @GetMapping("/upcoming")
    public void upcoming(){ log.info("upcoming 실행"); }

}










