package com.mediqal.community.controller;

import com.mediqal.community.domain.dto.UserDTO;
import com.mediqal.community.domain.vo.UserVO;
import com.mediqal.community.service.SignUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
        public RedirectView signup(UserDTO userDTO, RedirectAttributes redirectAttributes){
        signUserService.signUp(userDTO);
        redirectAttributes.addFlashAttribute("userNumber", userDTO.getUserNumber());
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
            return new RedirectView("/main/index");
        } catch (Exception e) {
            return new RedirectView("/user/signin");
        }
    }
//    }
//    Long userNumber = (Long) session.getAttribute("userNumber");
//    @PostMapping("signin")
//    public void singin(UserVO userVO){
//        signUserService.
//    }

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










