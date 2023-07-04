package com.loan.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.loan.domain.Application;
import com.loan.dto.ApplicationDTO.Response;
import com.loan.dto.ApplicationDTO.Request;
import com.loan.repository.ApplicationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ApplicationServiceTest {

    @InjectMocks
    ApplicationServiceImpl applicationService;

    @Mock
    private ApplicationRepository applicationRepository;

    @Spy
    private ModelMapper modelMapper;

    @Test
    void 신규_대출_신청_요청시_신규_대출_등록_엔티티를_반환한다() {
        Application entity = Application.builder()
                .name("Member A")
                .cellPhone("010-1234-5678")
                .email("memberA@gmail.com")
                .desireAmount(BigDecimal.valueOf(30000000))
                .build();

        Request request = Request.builder()
                .name("Member A")
                .cellPhone("010-1234-5678")
                .email("memberA@gmail.com")
                .desireAmount(BigDecimal.valueOf(30000000))
                .build();

        when(applicationRepository.save(ArgumentMatchers.any(Application.class))).thenReturn(entity);

        Response actual = applicationService.create(request);

        assertThat(actual.getDesireAmount()).isSameAs(entity.getDesireAmount());
        assertThat(actual.getName()).isSameAs(entity.getName());
    }

    @Test
    void 존재하는_대출신청아이디로_대출신청시_기존재하는_대출신청엔티티를_반환한다() {
        Long findId = 1L;

        Application entity = Application.builder()
                        .applicationId(1L)
                        .build();

        when(applicationRepository.findById(findId)).thenReturn(Optional.ofNullable(entity));

        Response actual = applicationService.get(findId);

        assertThat(actual.getApplicationId()).isSameAs(findId);
    }
}
