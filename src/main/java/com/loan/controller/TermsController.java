package com.loan.controller;

import com.loan.dto.ResponseDTO;
import com.loan.dto.TermsDTO.Request;
import com.loan.dto.TermsDTO.Response;
import com.loan.service.TermsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/terms")
public class TermsController extends AbstractController{

    private final TermsService termsService;

    public ResponseDTO<Response> create(@RequestBody Request request) {
        return ok(termsService.create(request));
    }
}
