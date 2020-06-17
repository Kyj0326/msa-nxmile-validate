package com.skcc.nxm.core.application.service;

import com.skcc.nxm.core.application.object.command.RequestDto;
import org.springframework.http.ResponseEntity;

public interface INxmileService {

    public ResponseEntity<String> dosomething(final RequestDto RequestDto);

    public ResponseEntity<String> doInterfaceExternalSystem(final RequestDto RequestDto);
}
