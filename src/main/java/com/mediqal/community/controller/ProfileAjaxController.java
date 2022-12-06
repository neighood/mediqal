package com.mediqal.community.controller;

import com.mediqal.community.domain.vo.BoardVO;
import com.mediqal.community.service.ProfileBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profileAjax/*")
@RequiredArgsConstructor
@Slf4j
public class ProfileAjaxController {

    private final ProfileBoardService boardService;

    @PostMapping("/board")
    public BoardVO getUserDetail(Long boardNumber){
        return boardService.ajaxSelect(boardNumber);
    }
}
