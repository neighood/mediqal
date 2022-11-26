package com.mediqal.community.service;

import com.mediqal.community.domain.dto.ConfirmDTO;
import com.mediqal.community.domain.vo.ConfirmVO;
import com.mediqal.community.domain.dto.Criteria;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("profile")
public class ProfileConfirmService implements ConfirmService{
    @Override
    public void register(ConfirmDTO confirmDTO) {

    }

    @Override
    public void modify(ConfirmDTO confirmDTO) {

    }

    @Override
    public void remove(Long confirmNumber) {

    }

    @Override
    public ConfirmDTO show(Long confirmNumber) {
        return null;
    }

    @Override
    public List<ConfirmVO> showAll(Criteria criteria) {
        return null;
    }

    @Override
    public int getTotal() {
        return 0;
    }
}
