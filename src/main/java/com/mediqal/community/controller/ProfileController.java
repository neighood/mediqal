package com.mediqal.community.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile/*")
@Slf4j
public class ProfileController {

    @GetMapping("/article")
    public void article(){ log.info("article 실행"); }

    @GetMapping("/info")
    public void info(){ log.info("info 실행"); }

    @GetMapping("/upcoming")
    public void upcoming(){ log.info("upcoming 실행"); }

}










