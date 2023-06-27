package com.loan.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.loan.domain.Counsel;
import com.loan.dto.CounselDTO.*;
import com.loan.repository.CounselRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
public class CounselServiceTest {

    @InjectMocks
    CounselServiceImpl counselService;

    @Mock
    private CounselRepository counselRepository;

    @Spy
    private ModelMapper modelMapper;

    @Test
    void Should_ReturnResponseOfNewCounselEntity_When_RequestCounsel() {
        Counsel entity = Counsel.builder()
                .name("member A")
                .cellPhone("010-1234-5678")
                .email("aaa@bbb.com")
                .memo("아자아자")
                .zipCode("12345")
                .address("서울시 퇴계로")
                .addressDetail("36 1301호")
                .build();

        Request request = Request.builder()
                .name("member A")
                .cellPhone("010-1234-5678")
                .email("aaa@bbb.com")
                .memo("아자아자")
                .zipCode("12345")
                .address("서울시 퇴계로")
                .addressDetail("36 1301호")
                .build();

        when(counselRepository.save(ArgumentMatchers.any(Counsel.class))).thenReturn(entity);
        Response actual = counselService.create(request);

        assertThat(actual.getName()).isSameAs(entity.getName());
    }
}
