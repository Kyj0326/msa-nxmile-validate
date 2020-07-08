package com.skcc.nxm.core.application.service;

import com.skcc.nxm.core.application.object.command.CardCodeValidateDto;
import org.springframework.http.ResponseEntity;

import java.util.concurrent.atomic.AtomicBoolean;

public interface IValidateService {

    ResponseEntity<AtomicBoolean> validateOrganCodeR1(final String organCode);

    ResponseEntity<String> doInterfaceExternalSystem(final CardCodeValidateDto requestDto);

    ResponseEntity<AtomicBoolean> validateOrganCodeR2(String organCode);

    ResponseEntity<AtomicBoolean> validateOrganCodeR9(String organCode);

    ResponseEntity<AtomicBoolean> validateOrganCodeM4(String organCode);

    ResponseEntity<AtomicBoolean> validateCardCode(CardCodeValidateDto cardCodeValidateDto);

}
