package com.mediqal.community.repository;

import com.mediqal.community.mapper.BoardMapper;
import com.mediqal.community.mapper.ConfirmMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ConfirmDAO {
    private final ConfirmMapper confirmMapper;
    
}
