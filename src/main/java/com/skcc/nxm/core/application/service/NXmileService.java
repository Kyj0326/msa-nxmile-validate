package com.skcc.nxm.core.application.service;

import com.skcc.nxm.core.application.object.command.RequestDto;
import com.skcc.nxm.core.port_infra.external_system.IExternalSampleSystem;
import com.skcc.nxm.infrastructure.external_system.ExternalCallSample_Atype;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Slf4j
@RequiredArgsConstructor
@Service
public class NXmileService implements INxmileService{

    @Override
    public ResponseEntity<String> dosomething(RequestDto RequestDto) {
        return null;
    }

    @Override
    public ResponseEntity<String> doInterfaceExternalSystem(final RequestDto RequestDto) {
        log.debug("[Service] doInterfaceExternalSystem Called - doInterfaceExternalSystem [{}]", RequestDto);

        IExternalSampleSystem externalSampleSystem;


            externalSampleSystem = new ExternalCallSample_Atype();


        //do Some Logic with External System
        return externalSampleSystem.doSomeExternalLogic( RequestDto );
    }

}
