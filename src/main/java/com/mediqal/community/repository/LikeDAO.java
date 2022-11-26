package com.mediqal.community.repository;

import com.mediqal.community.mapper.BoardMapper;
import com.mediqal.community.mapper.LikeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class LikeDAO {
    private final LikeMapper likeMapper;
    
}
