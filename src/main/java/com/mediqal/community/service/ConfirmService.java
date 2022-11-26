package com.mediqal.community.service;

import com.mediqal.community.domain.dto.ConfirmDTO;
import com.mediqal.community.domain.dto.Criteria;
import com.mediqal.community.domain.vo.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConfirmService {
    //    추가
    public void register(ConfirmDTO confirmDTO);
    //    수정
    public void modify(ConfirmDTO confirmDTO);
    //    삭제
    public void remove(Long confirmNumber);
    //    조회
    public ConfirmDTO show(Long confirmNumber);
    //    전체 조회
    public List<ConfirmVO> showAll(Criteria criteria);
    //    전체 개수
    public int getTotal();
}
