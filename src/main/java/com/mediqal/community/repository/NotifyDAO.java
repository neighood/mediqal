package com.mediqal.community.repository;

import com.mediqal.community.mapper.BoardMapper;
import com.mediqal.community.mapper.NotifyMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class NotifyDAO {
    private final NotifyMapper notifyMapper;
    
}
