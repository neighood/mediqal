package com.mediqal.community.repository;

import com.mediqal.community.mapper.BoardMapper;
import com.mediqal.community.mapper.IllMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class IllDAO {
    private final IllMapper illMapper;
    
}
