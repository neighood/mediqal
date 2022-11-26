package com.mediqal.community.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/*")
@Slf4j
public class AdminController {

    @GetMapping("/admin")
    public void admin(){
        log.info("admin 실행");
    }

    @GetMapping("/contentsTest")
    public void contentsTest(){ log.info("contentsTest 실행"); }

    @GetMapping("/grade")
    public void grade(){ log.info("grade 실행"); }

    @GetMapping("/userTest")
    public void userTest(){ log.info("userTest 실행"); }

}










