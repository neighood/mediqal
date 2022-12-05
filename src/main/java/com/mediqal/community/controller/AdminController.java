package com.mediqal.community.controller;

import com.mediqal.community.domain.dto.BoardDTO;
import com.mediqal.community.domain.dto.Criteria;
import com.mediqal.community.domain.dto.PageDTO;
import com.mediqal.community.domain.dto.UserDTO;
import com.mediqal.community.service.AdminBoardService;
import com.mediqal.community.service.AdminUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/admin/*")
@RequiredArgsConstructor
@Slf4j
public class AdminController {

    @Qualifier("admin")
    private final AdminUserService adminUserService;


    @Qualifier("admin")
    private final AdminBoardService adminBoardService;

    @GetMapping("/admin")
    public void admin(){
        log.info("admin 실행");
    }

    @GetMapping("/grade")
    public void grade(){ log.info("grade 실행"); }

    @GetMapping("/userTest")
    public void userTest(Criteria criteria, Model model){
        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }
        model.addAttribute("users", adminUserService.showAll(criteria));
        model.addAttribute("pagination", new PageDTO().createPageDTO(criteria, adminUserService.getTotal()));
    }

    @GetMapping("/contentsTest")
    public void contentsTest(Criteria criteria, Model model){
        BoardDTO boardDTO = new BoardDTO();
        boardDTO.setBoardCategory("community");
        boardDTO.setCriteria(criteria);

        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }
        model.addAttribute("boards", adminBoardService.showAll(boardDTO));
        model.addAttribute("pagination", new PageDTO().createPageDTO(criteria, adminBoardService.getTotal(boardDTO)));
    }

    @DeleteMapping("/{userNumber}")
    public void deleteUserTest(@PathVariable Long userNumber){
        adminUserService.remove(userNumber);
    }

    @DeleteMapping("contentsTest/{boardNumber}")
    public void deleteContentsTest(@PathVariable Long boardNumber){
        log.info("boardNumber : " + boardNumber);
        adminBoardService.remove(boardNumber);
    }

}







