package com.mediqal.community.controller;

import com.mediqal.community.domain.dto.BoardDTO;
import com.mediqal.community.domain.dto.Criteria;
import com.mediqal.community.domain.dto.PageDTO;
import com.mediqal.community.domain.dto.UserDTO;
import com.mediqal.community.domain.vo.UserVO;
import com.mediqal.community.service.ProfileBoardService;
import com.mediqal.community.service.ProfileLikeService;
import com.mediqal.community.service.ProfileUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    private final ProfileBoardService boardService;
    private final ProfileLikeService likeService;


    @GetMapping("/test")
    public void test(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("userNumber", (long) 1);
    }

//    유저 정보 보기
    @GetMapping("/info")
    public void info(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        Long userNumber = (Long) session.getAttribute("userNumber");
        log.info(String.valueOf(userService.show(userNumber)));
        model.addAttribute("userDTO", userService.show(userNumber));
    }

    @PostMapping("/info")
    public RedirectView info(UserDTO userDTO, HttpServletRequest request){
        HttpSession session = request.getSession();
        userDTO.setUserNumber((long)session.getAttribute("userNumber"));
        log.info(String.valueOf(userDTO.getUserImgVO()));
        userService.modify(userDTO);
        return new RedirectView("/profile/info?profileCheck=yes");
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
        return new RedirectView("/main/index?profileCheck=true");
    }

//  비밀번호 수정
    @GetMapping("/password")
    public void password(Model model){;}

    @PostMapping("/password")
    public RedirectView password(HttpServletRequest request, @RequestParam("userPassword") String userPassword, @RequestParam("userPasswordNew") String userPasswordNew){
        UserVO userVO = new UserVO();
        HttpSession session = request.getSession();

        log.info("비밀번호"+userPassword);
        log.info("새비밀번호"+userPasswordNew);
        userVO.setUserPassword(userPassword);
        userVO.setUserNumber((long)session.getAttribute("userNumber"));

        if(userService.updatePW(userVO, userPasswordNew)){
            return new RedirectView("/profile/password?profileCheck=yes");
        }
        else{
            return new RedirectView("/profile/password?profileCheck=no");
        }
    }

//    커뮤니티 게시판 리스트
    @GetMapping("/article")
    public void comList(HttpServletRequest request, Model model, Criteria criteria){
        BoardDTO boardDTO = new BoardDTO();
        HttpSession session = request.getSession();

        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }
        boardDTO.setBoardCategory("community");
        boardDTO.setUserNumber((long)session.getAttribute("userNumber"));
        boardDTO.setCriteria(criteria);

        int total = boardService.getTotal(boardDTO);

        model.addAttribute("likeTotal", boardService.profileGetLikeTotal(boardDTO));
        model.addAttribute("total", total);
        model.addAttribute("boards", boardService.showAll(boardDTO));
        model.addAttribute("pagination",new PageDTO().createPageDTO(criteria, total));
    }

//    커뮤니티 게시판 삭제
    @PostMapping("/articleDelete")
    public RedirectView comDelete(Long boardNumber, Criteria criteria){
        boardService.remove(boardNumber);
        String url = "/profile/article?page=" + criteria.getPage() + "&amount=" + criteria.getAmount();
        return new RedirectView(url+"&profileCheck=yes");
    }

//    후기 게시판 리스트
    @GetMapping("/reviews")
    public void reList(HttpServletRequest request, Model model, Criteria criteria){
        BoardDTO boardDTO = new BoardDTO();
        HttpSession session = request.getSession();

        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }
        boardDTO.setBoardCategory("review");
        boardDTO.setUserNumber((long)session.getAttribute("userNumber"));
        boardDTO.setCriteria(criteria);

        int total = boardService.getTotal(boardDTO);

        model.addAttribute("likeTotal", boardService.profileGetLikeTotal(boardDTO));
        model.addAttribute("total", total);
        model.addAttribute("boards", boardService.showAll(boardDTO));
        model.addAttribute("pagination",new PageDTO().createPageDTO(criteria, total));
    }

//    후기 게시판 삭제
    @PostMapping("/reviewsDelete")
    public RedirectView reDelete(Long boardNumber, Criteria criteria){
        boardService.remove(boardNumber);
        String url = "/profile/reviews?page=" + criteria.getPage() + "&amount=" + criteria.getAmount();
        return new RedirectView(url+"&profileCheck=yes");
    }

//    좋아요 게시판 리스트
@GetMapping("/like")
public void likeList(HttpServletRequest request, Model model, Criteria criteria){
    BoardDTO boardDTO = new BoardDTO();
    HttpSession session = request.getSession();

    if(criteria.getPage() == 0){
        criteria.create(1, 10);
    }
    boardDTO.setUserNumber((long)session.getAttribute("userNumber"));
    boardDTO.setCriteria(criteria);

    int total = likeService.getTotal(boardDTO);

    model.addAttribute("total", total);
    model.addAttribute("boards", likeService.showAll(boardDTO));
    model.addAttribute("pagination",new PageDTO().createPageDTO(criteria, total));
}

    //    좋아요 삭제
    @PostMapping("/likeDelete")
    public RedirectView likeDelete(Long likeNumber, Criteria criteria){
        likeService.remove(likeNumber);
        String url = "/profile/like?page=" + criteria.getPage() + "&amount=" + criteria.getAmount();
        return new RedirectView(url+"&profileCheck=yes");
    }


    @GetMapping("/upcoming")
    public void upcoming(){ log.info("upcoming 실행"); }

    @GetMapping("/reply")
    public void reply(){ log.info("upcoming 실행"); }

    @GetMapping("/notification")
    public void notification(){ log.info("leave 실행"); }

    @GetMapping("/email")
    public void email(){ log.info("email 실행"); }

}










