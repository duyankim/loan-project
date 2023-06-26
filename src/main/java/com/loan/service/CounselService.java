package com.loan.service;

import com.loan.dto.counselDTO.Request;
import com.loan.dto.counselDTO.Response;

public interface CounselService {

    Response create (Request request);
}
