package com.skcc.common.test;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class Controller {

    @GetMapping(value = "/")
    public void test(){

        log.debug("DEBUGTEST");
        log.info("INFOTEST");
        log.trace("TRACETEST");

    }
}
