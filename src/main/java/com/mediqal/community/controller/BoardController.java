package com.mediqal.community.controller;

import com.mediqal.community.aspect.annotation.LogStatus;
import com.mediqal.community.domain.criteria.BoardPageCountCriteria;
import com.mediqal.community.domain.dto.BoardDTO;
import com.mediqal.community.domain.dto.Criteria;
import com.mediqal.community.domain.dto.ReplyDTO;
import com.mediqal.community.domain.dto.UserDTO;
import com.mediqal.community.service.CommunityBoardService;
import com.mediqal.community.service.CommunityLikeService;
import com.mediqal.community.service.CommunityReplyService;
import com.mediqal.community.service.ProfileUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board/*")
@Slf4j
public class BoardController {
//    @Qualifier("community")
//    private final BoardService boardService;

    private final CommunityBoardService boardService;
    private final CommunityReplyService communityReplyService;
    private final CommunityLikeService likeService;

    @Qualifier("profile")
    private final ProfileUserService userService;


    //    커뮤니티 게시글 목록
    @LogStatus
//    @GetMapping("/list")
    @GetMapping("/list")
//    @GetMapping("/board")
    public void listBoard(Criteria criteria, Model model){
        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }
//        criteria.createCategory("community");
//        criteria.createCategory("review");
        model.addAttribute("boards", boardService.showAll(criteria));
        model.addAttribute("pagination",new BoardPageCountCriteria().createBoardPageCountCriteria(criteria, boardService.getTotal()));
    }

    @LogStatus
//    @GetMapping("/list")
    @GetMapping("/community/list")
//    @GetMapping("/board")
    public void communityBoard(Criteria criteria, Model model){
        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }
        criteria.createCategory("community");
//        criteria.createCategory("review");
        model.addAttribute("boards", boardService.boardShowAll(criteria));
        model.addAttribute("pagination",new BoardPageCountCriteria().createBoardPageCountCriteria(criteria, boardService.getCategoryTotal("community")));
    }

//    @LogStatus
////    @GetMapping("/list")
//    @GetMapping( "/review/list")
////    @GetMapping("/board")
//    public String reviewBoard(Criteria criteria, Model model){
//        if(criteria.getPage() == 0){
//            criteria.create(1, 10);
//        }
//        criteria.createCategory("review");
////        criteria.createCategory("review");
//        model.addAttribute("boards", boardService.showAll(criteria));
//        model.addAttribute("pagination",new BoardPageCountCriteria().createBoardPageCountCriteria(criteria, boardService.getCategoryTotal("review")));
//        return "/board/list";
//    }

    @LogStatus
//    @GetMapping("/list")
    @GetMapping( "/review/list")
//    @GetMapping("/board")
    public void reviewBoard(Criteria criteria, Model model){
        if(criteria.getPage() == 0){
            criteria.create(1, 10);
        }
        criteria.createCategory("review");
//        criteria.createCategory("review");
        model.addAttribute("boards", boardService.boardShowAll(criteria));
        model.addAttribute("pagination",new BoardPageCountCriteria().createBoardPageCountCriteria(criteria, boardService.getCategoryTotal("review")));
    }

//    @LogStatus
////    @GetMapping("/list")
//    @GetMapping( "/list")
////    @GetMapping("/board")
//    public RedirectView listBoard(Criteria criteria, Model model){
//        log.info("페이지 : " + criteria);
//        if(criteria.getBoardCategory().equals((String) "review")) {
//        model.addAttribute("boards", boardService.showAll(criteria));
//        model.addAttribute("pagination",new BoardPageCountCriteria().createBoardPageCountCriteria(criteria, boardService.getCategoryTotal("review")));
//            return new RedirectView("/review/board/list");
//        }
//        else {
//            model.addAttribute("boards", boardService.showAll(criteria));
//            model.addAttribute("pagination",new BoardPageCountCriteria().createBoardPageCountCriteria(criteria, boardService.getCategoryTotal("review")));
//        }
//        return new RedirectView("/community/board/list");
//    }

//    커뮤니티 게시글 상세 보기
//    @LogStatus
//    @GetMapping("/board_detail")
//    public void board_detail(Long boardNumber){
//
//    }

    @LogStatus
    @RequestMapping(value={"/{boardNumber}", "/{boardNumber}"}, method=RequestMethod.GET)
    public ModelAndView all_board_detail(@PathVariable Long boardNumber, HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView("/board/board_detail");

        BoardDTO board = boardService.show(boardNumber);
        mv.addObject("board", board);

        ReplyDTO newReply = new ReplyDTO();
        mv.addObject("newReply", newReply);

//        List<ReplyDTO> replies = communityReplyService.showAll(boardNumber);
        List<ReplyDTO> replies = communityReplyService.replyShowAll(boardNumber);
        mv.addObject("replies", replies);

//      TODO : 세션테스트 - 전체리스트
//        HttpSession session = request.getSession();
//        Long number = 10L;
//        session.setAttribute("userNumber", number);

        return mv;
    }

    @LogStatus
    @RequestMapping(value={"/review/{boardNumber}", "/community/{boardNumber}"}, method=RequestMethod.GET)
    public ModelAndView board_detail(@PathVariable Long boardNumber, HttpServletRequest request) throws Exception{
        ModelAndView mv = new ModelAndView("/board/board_detail");
//        HttpSession session = request.getSession();
//        BoardDTO boardDTO = new BoardDTO();
        /*if(session.getAttribute("userNumber") != null) {
            boardDTO.setUserNumber((long) session.getAttribute("userNumber"));
            boardDTO.setBoardNumber(boardNumber);

            int likeCheck = likeService.check(boardDTO);

            mv.addObject("likeCheck", likeCheck);
        }*/

        BoardDTO board = boardService.show(boardNumber);
        mv.addObject("board", board);

        UserDTO boardUser = userService.show(board.getUserNumber());
        mv.addObject("boardUser", boardUser);

//        List<ReplyDTO> replies = communityReplyService.showAll(boardNumber);
        List<ReplyDTO> replies = communityReplyService.replyShowAll(boardNumber);
        replies.forEach(reply -> {
            reply.setUserNickname(userService.show(reply.getUserNumber()).getUserNickname());
            reply.setUserImgVO(userService.show(reply.getUserNumber()).getUserImgVO());
            log.info("댓글 : " + reply);
        });
        mv.addObject("replies", replies);

//      TODO : 세션테스트 - 진짜 서비스
//        HttpSession session = request.getSession();
//        Long number = 10L;
//        session.setAttribute("userNumber", number);

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
    public RedirectView write(HttpServletRequest request, BoardDTO boardDTO){
//        TODO: 세션확인 복붙용
        HttpSession session = request.getSession();
        Long userNumber = (Long) session.getAttribute("userNumber");
        boardDTO.setUserNumber(userNumber);
//        TODO: 유저 넘버 세션에서 넘기기로 바꾸기
//        boardDTO.setUserNumber(10L);
        String category = boardDTO.getBoardCategory().toString();
        log.info("결과" + boardDTO.getBoardCategory());
//        boardDTO.setBoardCategory(category);
//        log.info("result : " + boardDTO);
//        String url = "/main/index";
//        redirectAttributes.addFlashAttribute("boardNumber", boardDTO.getBoardNumber());
        boardService.register(boardDTO);
        if(category.equals((String) "review")) {
            return new RedirectView("/board/review/list");
        } else {
            return new RedirectView("/board/community/list");
        }

//        if (boardDTO.getBoardCategory() == "community") {
//            url = "/board/c/list";
//        }
//        if (boardDTO.getBoardCategory() == "review") {
//            url = "/board/r/list";
//        }
//        return new RedirectView(url);
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

    @LogStatus
    @RequestMapping(value={"/review/{boardNumber}/edit", "/community/{boardNumber}/edit"}, method=RequestMethod.GET)
    public ModelAndView reviewEdit(@PathVariable Long boardNumber, HttpServletRequest request) throws Exception{
//        유저확인
        HttpSession session = request.getSession();
        Long userNumber = (Long) session.getAttribute("userNumber");

//
//        userNumber = 21L;
//        유효성 확인
        BoardDTO board = boardService.show(boardNumber);

        ModelAndView mv = new ModelAndView("/board/edit");

        if(userNumber != board.getUserNumber()) {
            log.info("유효성확인");
            if(board.getBoardCategory().equals((String) "review")) {
                mv.setViewName("redirect:/board/review/list");
                return mv;
            } else {
                mv.setViewName("redirect:/board/community/list");
                return mv;
            }
        }

        board.setUserNumber(userNumber);

        mv.addObject("board", board);

//        댓글 어차피 안 보임
//        List<ReplyDTO> replies = communityReplyService.showAll(boardNumber);
//        List<ReplyDTO> replies = communityReplyService.replyShowAll(boardNumber);
//        mv.addObject("replies", replies);

        return mv;
    }

    @LogStatus
    @PostMapping("/edit")
    public RedirectView update(BoardDTO boardDTO){
        String category = boardDTO.getBoardCategory();
        log.info("보드확인" + boardDTO);
        boardService.modify(boardDTO);
        if(category.equals((String) "review")) {
            return new RedirectView("/board/review/list");
        } else {
            return new RedirectView("/board/community/list");
        }
    }

    //    게시글 삭제
    @LogStatus
    @GetMapping(value={"/review/{boardNumber}/remove", "/community/{boardNumber}/remove"})
    public RedirectView delete(@PathVariable Long boardNumber, HttpServletRequest request){
        //        유저확인
        HttpSession session = request.getSession();
        Long userNumber = (Long) session.getAttribute("userNumber");

//
//        userNumber = 21L;
//        유효성 확인
        BoardDTO board = boardService.show(boardNumber);
        String category = board.getBoardCategory();

        if(userNumber != board.getUserNumber()) {
            log.info("유효성확인");
            if(board.getBoardCategory().equals((String) "review")) {
                return new RedirectView("/board/review/list");
            } else {
                return new RedirectView("/board/community/list");
            }
        }

        // 정상작동
        boardService.remove(boardNumber);
        if(category.equals((String) "review")) {
            return new RedirectView("/board/review/list");
        } else {
            return new RedirectView("/board/community/list");
        }
    }

}










