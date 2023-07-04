package com.loan.controller;

import com.loan.dto.ApplicationDTO.Response;
import com.loan.dto.ApplicationDTO.Request;
import com.loan.dto.ResponseDTO;
import com.loan.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/applications")
public class ApplicationController extends AbstractController{

    private final ApplicationService applicationService;

    @PostMapping
    public ResponseDTO<Response> create(@RequestBody Request request) {
        return ok(applicationService.create(request));
    }

    @GetMapping("/{applicationId}")
    public ResponseDTO<Response> get(@PathVariable long applicaionId) {
        return ok(applicationService.get(applicaionId));
    }
}
