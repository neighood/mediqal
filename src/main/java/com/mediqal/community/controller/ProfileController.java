package com.mediqal.community.controller;

import com.mediqal.community.domain.dto.UserDTO;
import com.mediqal.community.domain.vo.UserVO;
import com.mediqal.community.service.ProfileUserService;
import com.mediqal.community.service.UserService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@RequestMapping("/profile/*")
@Slf4j
public class ProfileController {

    @Qualifier("profile")
    private final ProfileUserService userService;


    @GetMapping("/test")
    public void test(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("userNumber", (long) 1);
    }

    @GetMapping("/article")
    public void article(){ log.info("article 실행"); }

//    유저 정보 보기
    @GetMapping("/info")
    public void info(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        Long userNumber = (Long) session.getAttribute("userNumber");
        model.addAttribute("userDTO", userService.show(userNumber));
    }

    @PostMapping("/info")
    public RedirectView info(UserDTO userDTO, HttpServletRequest request){
        HttpSession session = request.getSession();
        userDTO.setUserNumber((long)session.getAttribute("userNumber"));
        userService.modify(userDTO);
        return new RedirectView("/profile/info");
    }

//  회원 탈퇴
    @GetMapping("/leave")
    public void leave(Model model){
        ;
        }

    @PostMapping("/leave")
    public RedirectView leave(HttpServletRequest request){
        HttpSession session = request.getSession();
        userService.remove((long)session.getAttribute("userNumber"));
        session.invalidate();
        return new RedirectView("/main/index");
    }

//  비밀번호 수정
    @GetMapping("/password")
    public void password(){;}

    @PostMapping("/password")
    public RedirectView password(HttpServletRequest request, UserVO userVO, String userPasswordNew){
        HttpSession session = request.getSession();
        userVO.setUserNumber((long)session.getAttribute("userNumber"));
        if(userService.updatePW(userVO, userPasswordNew)){
            return new RedirectView("profile/password?updatePW=yes");
        }
        else{
            return new RedirectView("profile/password?updatePW=no");
        }
    }

//









    @GetMapping("/upcoming")
    public void upcoming(){ log.info("upcoming 실행"); }

}










