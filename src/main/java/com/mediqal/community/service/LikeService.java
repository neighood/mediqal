package com.mediqal.community.service;

import com.mediqal.community.domain.vo.LikeVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LikeService {
    //    추가
    public void register(LikeVO likeVO);
    //    삭제
    public void remove(LikeVO likeVO);
    //    조회
    public Boolean show(Long userNumber);
    //    전체 조회
    public List<LikeVO> showAll(Long userNumber);
    //    전체 개수
    public int getTotal();
}
