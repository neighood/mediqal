package com.mediqal.community.controller;

import com.mediqal.community.domain.dto.ReplyDTO;
import com.mediqal.community.domain.vo.ReplyVO;
import com.mediqal.community.service.CommunityReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reply/*")
@Slf4j
public class ReplyController {

    private final CommunityReplyService communityReplyService;
    //    추가
    @PostMapping("/write")
    public void write(@RequestBody ReplyDTO replyDTO){
        log.info("서버 댓글 들어옴");
        communityReplyService.register(replyDTO);
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
