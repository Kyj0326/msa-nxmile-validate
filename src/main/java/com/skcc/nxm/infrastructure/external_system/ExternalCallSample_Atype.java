package com.skcc.nxm.infrastructure.external_system;

import com.skcc.common.error.handler.ExternalErrorHandler;
import com.skcc.common.intercept.RestTemplateClientHttpRequestInterceptor;
import com.skcc.nxm.core.application.object.command.RequestDto;
import com.skcc.nxm.core.port_infra.external_system.IExternalSampleSystem;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Slf4j
public class ExternalCallSample_Atype implements IExternalSampleSystem {

    private RestTemplateBuilder restTemplateBuilder;
    private RestTemplate restTemplate;

    public ExternalCallSample_Atype(){

        restTemplateBuilder = new RestTemplateBuilder();

        restTemplate = restTemplateBuilder.rootUri("http://localhost:8080")
                .additionalInterceptors(new RestTemplateClientHttpRequestInterceptor())
                .errorHandler(new ExternalErrorHandler())
                .setConnectTimeout(Duration.ofMinutes(3))
                .build();
    }

    @Override
    public ResponseEntity<String> doSomeExternalLogic(final RequestDto requestDto ) {
        log.debug("[ExternalCallSample_Atype Called] doSomeExternalLogic");

        ResponseEntity<String> result = restTemplate.getForEntity("/member/sample", String.class);

        return result;
    }
}
