package com.mediqal.community.controller;

import com.mediqal.community.domain.dto.BoardDTO;
import com.mediqal.community.service.CommunityLikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boardLike/*")
@RequiredArgsConstructor
public class BoardLikeController {

    private final CommunityLikeService likeService;


    @PostMapping("/getTotal")
    public int getTotal(BoardDTO boardDTO){
        return likeService.getTotal(boardDTO);
    }

    @PostMapping("/insert")
    public int insert(BoardDTO boardDTO){
        likeService.insert(boardDTO);
        return likeService.getTotal(boardDTO);
    }

    @PostMapping("/delete")
    public int delete(BoardDTO boardDTO){
        likeService.delete(boardDTO);
        return likeService.getTotal(boardDTO);
    }

    @PostMapping("/check")
    public int check(BoardDTO boardDTO){
        return likeService.check(boardDTO);
    }

}
