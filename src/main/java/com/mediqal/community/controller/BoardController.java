package com.mediqal.community.controller;

import com.mediqal.community.aspect.annotation.LogStatus;
import com.mediqal.community.domain.criteria.BoardPageCountCriteria;
import com.mediqal.community.domain.dto.BoardDTO;
import com.mediqal.community.domain.dto.Criteria;
import com.mediqal.community.domain.dto.ReplyDTO;
import com.mediqal.community.service.BoardService;
import com.mediqal.community.service.CommunityReplyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/*")
public class BoardController {
    @Qualifier("community")
    private final BoardService boardService;

    private final CommunityReplyService communityReplyService;


    //    커뮤니티 게시글 목록
    @LogStatus
    @GetMapping("/list")
//    @GetMapping("/board")
    public void board(Criteria criteria, Model model){
        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }
        model.addAttribute("boards", boardService.showAll(criteria));
        model.addAttribute("pagination",new BoardPageCountCriteria().createBoardPageCountCriteria(criteria, boardService.getTotal()));
    }

//    커뮤니티 게시글 상세 보기
//    @LogStatus
//    @GetMapping("/board_detail")
//    public void board_detail(Long boardNumber){
//
//    }

    @LogStatus
    @RequestMapping(value="/{boardNumber}", method=RequestMethod.GET)
    public ModelAndView board_detail(@PathVariable Long boardNumber) throws Exception{
        ModelAndView mv = new ModelAndView("/board/board_detail");

        BoardDTO board = boardService.show(boardNumber);
        mv.addObject("board", board);

//        List<ReplyDTO> replies = communityReplyService.showAll(boardNumber);
        List<ReplyDTO> replies = communityReplyService.replyShowAll(boardNumber);
        mv.addObject("replies", replies);

        return mv;
    }
//    public ReplyVO show(@PathVariable Long replyNumber){
//        return replyService.show(replyNumber);
//    }

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
    @LogStatus
    @GetMapping("/write")
    public void write(Criteria criteria, Model model){
        model.addAttribute("board", new BoardDTO());
    }

    @LogStatus
    @PostMapping("/write")
    public RedirectView write(BoardDTO boardDTO, RedirectAttributes redirectAttributes){
//        TODO: 세션확인으로 대체
        boardDTO.setUserNumber(10L);
        boardService.register(boardDTO);
//        redirectAttributes.addFlashAttribute("boardNumber", boardDTO.getBoardNumber());
        return new RedirectView("/board/list");
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










