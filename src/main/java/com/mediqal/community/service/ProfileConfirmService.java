package com.mediqal.community.service;

import com.mediqal.community.domain.dto.ConfirmDTO;
import com.mediqal.community.domain.vo.CertifyVO;
import com.mediqal.community.domain.vo.ConfirmVO;
import com.mediqal.community.domain.dto.Criteria;
import com.mediqal.community.repository.CertifyDAO;
import com.mediqal.community.repository.ConfirmDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Qualifier("profile")
public class ProfileConfirmService implements ConfirmService{

    private final ConfirmDAO confirmDAO;
    private final CertifyDAO certifyDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void register(ConfirmDTO confirmDTO) {
        confirmDAO.insert(confirmDTO);
        List<CertifyVO> certifyVOs = confirmDTO.getCertifyVOs();
//        Optional : 검증
        Optional.ofNullable(certifyVOs).ifPresent(fileList -> {
            fileList.forEach(file -> {
                file.setConfirmNumber(confirmDTO.getConfirmNumber());
                certifyDAO.insert(file);
            });
        });
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
