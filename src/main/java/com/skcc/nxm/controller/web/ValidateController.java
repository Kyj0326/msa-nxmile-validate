package com.skcc.nxm.controller.web;

import com.skcc.nxm.core.application.object.command.CardCodeValidateDto;
import com.skcc.nxm.core.application.service.IValidateService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/validate")
public class ValidateController {


    private final IValidateService validateService;

    @GetMapping("/organr1/{organCode}")
    public ResponseEntity<AtomicBoolean> validateOrganCodeR1(@PathVariable String organCode){

        return validateService.validateOrganCodeR1(organCode);

    }

    @GetMapping("/organr2/{organCode}")
    public ResponseEntity<AtomicBoolean> validateOrganCodeR2(@PathVariable String organCode){

        return validateService.validateOrganCodeR2(organCode);

    }

    @GetMapping("/organr9/{organCode}")
    public ResponseEntity<AtomicBoolean> validateOrganCodeR9(@PathVariable String organCode){

        return validateService.validateOrganCodeR9(organCode);

    }

    @GetMapping("/organm4/{organCode}")
    public ResponseEntity<AtomicBoolean> validateOrganCodeM4(@PathVariable String organCode){

        return validateService.validateOrganCodeM4(organCode);

    }

    @GetMapping("/cardcode")
    public ResponseEntity<AtomicBoolean> validateCoopCardCode(@RequestBody CardCodeValidateDto cardCodeValidateDto){

        return validateService.validateCardCode(cardCodeValidateDto);
    }

}
