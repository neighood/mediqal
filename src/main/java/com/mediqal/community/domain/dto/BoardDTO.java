package com.mediqal.community.domain.dto;

import com.mediqal.community.domain.vo.*;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class BoardDTO {
    private Long boardNumber;

    private Long userNumber;

    private String boardTitle;

    private String boardContent;

    private String boardCategory;

    private String boardRegisterDate;

    private String boardUpdateDate;

    private String userNickname;

    private Long boardView;

    private UserVO userVO;

    private UserImgVO userImgVO;

    private LikeVO likeVO;

    private int likeCount;

    private int replyCount;

    private List<BoardImgVO> boardImgVOs;

    private List<TagVO> tagVOs;

    private Criteria criteria;

    private String likeNumber;



    public void create(String boardTitle, Long userNumber, String boardContent) {
        this.boardTitle = boardTitle;
        this.userNumber = userNumber;
        this.boardContent = boardContent;
    }

    public void create(Long boardNumber, String boardTitle, String boardContent, Long boardView) {
        this.boardNumber = boardNumber;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardView = boardView;
    }

    public void create(String boardTitle, String boardContent) {
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
    }

    public void create(BoardDTO boardDTO) {
        this.boardNumber = boardDTO.getBoardNumber();
        this.userNumber = boardDTO.getUserNumber();
        this.boardTitle = boardDTO.getBoardTitle();
        this.boardContent = boardDTO.getBoardContent();
        this.boardView = boardDTO.getBoardView();
        this.userNickname = boardDTO.getUserNickname();
        this.boardCategory = boardDTO.getBoardCategory();
        this.boardRegisterDate = boardDTO.getBoardRegisterDate();
    }

    public void create(BoardVO boardVO) {
        this.boardNumber = boardVO.getBoardNumber();
        this.boardTitle = boardVO.getBoardTitle();
        this.boardContent = boardVO.getBoardContent();
        this.boardView = boardVO.getBoardView();
    }
}
