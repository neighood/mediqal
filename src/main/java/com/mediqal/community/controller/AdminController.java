package com.mediqal.community.controller;

import com.mediqal.community.domain.dto.Criteria;
import com.mediqal.community.service.AdminUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*")
@Slf4j
public class AdminController {

    @Qualifier("admin")
    private final AdminUserService adminUserService;

    public AdminController(AdminUserService adminUserService) {
        this.adminUserService = adminUserService;
    }

    @GetMapping("/admin")
    public void admin(){
        log.info("admin 실행");
    }

    @GetMapping("/contentsTest")
    public void contentsTest(){ log.info("contentsTest 실행"); }

    @GetMapping("/grade")
    public void grade(){ log.info("grade 실행"); }

    @GetMapping("/userTest")
    public void userTest(Criteria criteria, Model model){
        model.addAttribute("adminUserList", adminUserService.showAll(criteria));
    }

    @PostMapping("/userTest")
    public void userTestSelect(Long userNumber){
        adminUserService.show(10L);
    }

}









