package com.mediqal.community.controller;

import com.mediqal.community.aspect.annotation.LogStatus;
import com.mediqal.community.domain.dto.BoardDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {

//    커뮤니티 게시글 목록
    @LogStatus
    @GetMapping("/board")
    public void board(){

    }

//    커뮤니티 게사글 상세 보기
    @LogStatus
    @GetMapping("/board_detail")
    public void board_detail(Long boardNumber){

    }

//    리뷰 게시글 목록
    @LogStatus
    @GetMapping("/review")
    public void review(){

    }

//    리뷰 게시글 상세 보기
    @LogStatus
    @GetMapping("/review_detail")
    public void review_detail(Long boardNumber){

    }

//    게시글 등록
//    @LogStatus
//    @GetMapping("/write")
//    public void write(){
//
//    }

    @LogStatus
    @PostMapping("/write")
    public RedirectView write(BoardDTO boardDTO, RedirectAttributes redirectAttributes){
        return new RedirectView("");
    }

//    게시글 수정
//    @LogStatus
//    @GetMapping("/write")
//    public void write(Long boardNumber){
//    }

    @LogStatus
    @PostMapping("/update")
    public RedirectView update(BoardDTO boardDTO, RedirectAttributes redirectAttributes){
        return new RedirectView("");
    }

//    게시글 삭제
    @LogStatus
    @GetMapping("/delete")
    public RedirectView delete(Long boardNumber){
        return new RedirectView("");
    }

}










