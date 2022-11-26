package com.mediqal.community.repository;

import com.mediqal.community.mapper.BoardImgMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardImgDAO {
    private final BoardImgMapper boardImgMapper;
    
}
