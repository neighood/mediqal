package com.mediqal.community.controller;

import com.mediqal.community.aspect.annotation.LogStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main/*")
public class MainController {

    @LogStatus
    @GetMapping("/index")
    public void index(){
    }




}










