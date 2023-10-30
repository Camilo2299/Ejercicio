package com.pichincha.api;

import com.pichincha.api.dataTest.DataTest;
import com.pichincha.model.enums.TechnicalExceptionEnum;
import com.pichincha.usecase.devopsservice.DevOpsServiceUseCase;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import static org.assertj.core.api.Assertions.assertThat;
import com.pichincha.model.exceptions.TechnicalException;

@SpringBootApplication
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ApiRestTest {
    @InjectMocks
    private ApiRest apiRest;
    @Mock
    private DevOpsServiceUseCase devOpsServiceUseCase;
    @BeforeAll
    public void init() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void sendMessage() {
        Mockito.when(devOpsServiceUseCase.sendRequestApi(DataTest.getRequestApi().getMessage(),DataTest
                        .getRequestApi().getTo(), DataTest.getRequestApi().getFrom(), DataTest.getRequestApi().getTimeToLifeSec()))
                .thenReturn(Mono.just(DataTest.getResponseApi()));
        StepVerifier.create(apiRest.sendMessage(DataTest.getRequestApi()))
                .assertNext(responseApi -> {
                    assertThat(responseApi.getStatusCode().value()).isEqualTo(200);
                })
                .verifyComplete();
    }
    @Test
    void validateGet() {
        StepVerifier.create(apiRest.validateGet())
                .expectErrorMatches(throwable -> throwable instanceof TechnicalException &&
                        ((TechnicalException) throwable).getTechnicalExceptionEnum()
                                .equals(TechnicalExceptionEnum.ERROR)
                ).verifyLater();
    }
    @Test
    void validatePut() {
        StepVerifier.create(apiRest.validateGet())
                .expectErrorMatches(throwable -> throwable instanceof TechnicalException &&
                        ((TechnicalException) throwable).getTechnicalExceptionEnum()
                                .equals(TechnicalExceptionEnum.ERROR)
                ).verifyLater();
    }
    @Test
    void validateDelete() {
        StepVerifier.create(apiRest.validateGet())
                .expectErrorMatches(throwable -> throwable instanceof TechnicalException &&
                        ((TechnicalException) throwable).getTechnicalExceptionEnum()
                                .equals(TechnicalExceptionEnum.ERROR)
                ).verifyLater();
    }


}
