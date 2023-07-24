package com.loan.service;

import com.loan.dto.TermsDTO.Response;
import com.loan.dto.TermsDTO.Request;

public interface TermsService {

    Response create(Request request);
}
