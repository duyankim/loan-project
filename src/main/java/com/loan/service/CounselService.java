package com.loan.service;

import com.loan.dto.CounselDTO.*;

public interface CounselService {

    // 상담 등록 기능
    Response create (Request request);

    // 상담 조회 기능
    Response get(Long counselId);

    // 상담 수정 기능
    Response update(Long counselId, Request request);
    
    // 상담 삭제 기능
    void delete(Long counselId);
}
