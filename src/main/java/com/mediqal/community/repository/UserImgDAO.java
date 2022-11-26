package com.mediqal.community.repository;

import com.mediqal.community.mapper.UserImgMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserImgDAO {
    private final UserImgMapper userImgMapper;
    
}
