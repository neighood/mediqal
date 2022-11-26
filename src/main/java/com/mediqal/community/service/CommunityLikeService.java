package com.mediqal.community.service;

import com.mediqal.community.domain.vo.LikeVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Qualifier("community") @Primary
public class CommunityLikeService implements LikeService{

    @Override
    public void register(LikeVO likeVO) {

    }

    @Override
    public void remove(LikeVO likeVO) {

    }

    @Override
    public Boolean show(Long userNumber) {
        return null;
    }

    @Override
    public List<LikeVO> showAll(Long userNumber) {
        return null;
    }

    @Override
    public int getTotal() {
        return 0;
    }
}
