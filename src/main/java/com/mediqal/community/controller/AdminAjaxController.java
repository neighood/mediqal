package com.mediqal.community.controller;

import com.mediqal.community.domain.dto.BoardDTO;
import com.mediqal.community.domain.dto.UserDTO;
import com.mediqal.community.domain.vo.UserVO;
import com.mediqal.community.service.AdminBoardService;
import com.mediqal.community.service.AdminUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/adminAjax/*")
@RequiredArgsConstructor
@Slf4j
public class AdminAjaxController {

    @Qualifier("admin")
    private final AdminUserService adminUserService;

    @Qualifier("admin")
    private final AdminBoardService adminBoardService;

    @DeleteMapping("/{userNumber}")
    public void deleteUserTest(@PathVariable Long userNumber){
        adminUserService.remove(userNumber);
    }

    @GetMapping("/{boardNumber}")
    public void deleteContentsTest(@PathVariable Long boardNumber){
        adminBoardService.remove(boardNumber);
    }

//    @PostMapping("/{boardNumber}")
//    public void showSelect(@PathVariable Long boardNumber, Model model){
//        model.addAttribute("board", adminBoardService.show(boardNumber));
////        adminBoardService.show(boardNumber);
//    }

    @GetMapping("/boardDetailRead")
    public BoardDTO getBoardDetail(Long boardNumber){
        return adminBoardService.show(boardNumber);
    }

    @GetMapping("/userDetailRead")
    public UserVO getUserDetail(Long userNumber){
        return adminUserService.showTest(userNumber);
    }

//    @PostMapping("/{boardNumber}")
//    public BoardDTO show(@PathVariable Long boardNumber){
//        return adminBoardService.show(boardNumber);
//    }

//    @GetMapping("/{replyNumber}")
//    public ReplyVO show(@PathVariable Long replyNumber){
//        return replyService.show(replyNumber);
//    }
}
