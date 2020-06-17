package com.skcc.nxm.core.port_infra.external_system;

import com.skcc.nxm.core.application.object.command.RequestDto;
import org.springframework.http.ResponseEntity;

public interface IExternalSampleSystem {

    public ResponseEntity<String> doSomeExternalLogic(final RequestDto swingMockCommandApiRequestDTO);

}