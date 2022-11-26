package com.mediqal.community.controller;

import com.mediqal.community.domain.dto.ReplyDTO;
import com.mediqal.community.domain.vo.ReplyVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reply/*")
public class ReplyController {

//    추가
    @PostMapping("/write")
    public void write(@RequestBody ReplyVO replyVO){

    }

//    전체 조회
    @GetMapping("/list/{boardNumber}/{page}")
    public ReplyDTO list(@PathVariable("boardNumber") Long boardNumber, @PathVariable int page){
        return new ReplyDTO();
    }

//    수정
    @PostMapping("/modify")
    public void modify(@RequestBody ReplyVO replyVO){

    }

//    삭제
    @GetMapping("/remove/{replyNumber}")
    public void remove(@PathVariable Long replyNumber){

    }


}
