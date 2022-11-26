package com.mediqal.community.repository;

import com.mediqal.community.mapper.BoardMapper;
import com.mediqal.community.mapper.TagMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TagDAO {
    private final TagMapper tagMapper;
    
}
