package com.pichincha.usecase.devopsservice;

import com.pichincha.model.requestapi.gateways.RequestApiRepository;
import com.pichincha.model.responseapi.gateways.ResponseApiRepository;
import com.pichincha.usecase.datatest.DataTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import static org.assertj.core.api.Assertions.assertThat;
import com.pichincha.model.responseapi.ResponseApi;

@ExtendWith(MockitoExtension.class)
public class TestDevOpsServiceUseCase {
    @Mock
    private RequestApiRepository requestApiRepository;
    @Mock
    private ResponseApiRepository responseApiRepository;
    @InjectMocks
    private DevOpsServiceUseCase devOpsServiceUseCase;

    @Test
    public void testSendRequestApi() {
        Mockito.when(requestApiRepository.sendRequestApi(DataTest.getRequestApi().getMessage(),DataTest.getRequestApi().getTo(), DataTest.getRequestApi().getFrom(), DataTest.getRequestApi().getTimeToLifeSec()))
                .thenReturn(Mono.just(DataTest.getRequestApi()));
        Mockito.when(responseApiRepository.responseApi(DataTest.getResponseApi().getMessage()))
                .thenReturn(Mono.just(DataTest.getResponseApi()));
        StepVerifier.create(devOpsServiceUseCase.sendRequestApi(DataTest.getRequestApi().getMessage(),DataTest.getRequestApi().getTo(), DataTest.getRequestApi().getFrom(), DataTest.getRequestApi().getTimeToLifeSec()))
                .assertNext(responseApi -> {
                    assertThat(responseApi)
                            .extracting(ResponseApi::getMessage)
                            .isEqualTo(DataTest.getResponseApi().getMessage());
                })
                .verifyComplete();
    }

}
