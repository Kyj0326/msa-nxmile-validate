package com.skcc.nxm.core.application.service;

import com.skcc.common.error.ErrorCode;
import com.skcc.common.error.exception.BusinessException;
import com.skcc.nxm.core.application.object.command.CardCodeValidateDto;
import com.skcc.nxm.core.domain.entity.card.CoopCardCode;
import com.skcc.nxm.core.domain.entity.etc.GrpCommonCode;
import com.skcc.nxm.core.domain.entity.etc.GroupCode;
import com.skcc.nxm.core.port_infra.external_system.IExternalSampleSystem;
import com.skcc.nxm.core.port_infra.persistent.card.ICoopCardCodeRepository;
import com.skcc.nxm.core.port_infra.persistent.etc.IGroupCodeRepository;
import com.skcc.nxm.infrastructure.external_system.ExternalCallSample_Atype;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicBoolean;


@Slf4j
@RequiredArgsConstructor
@Service
public class ValidateService implements IValidateService {

    private final IGroupCodeRepository groupCodeRepository;
    private final ICoopCardCodeRepository coopCardCodeRepository;


    @Override
    public ResponseEntity<AtomicBoolean> validateOrganCodeR1(final String organCode) {

        GrpCommonCode grpCommonCode = GrpCommonCode.ORGANCODE_R1;

        GroupCode groupCode = groupCodeRepository.findById(grpCommonCode.getGroupCode())
                             .orElseThrow(() -> new BusinessException(ErrorCode.ENTITY_NOT_FOUND));
        return ResponseEntity.ok(groupCode.validate(grpCommonCode.getCommonCode(), organCode));
    }


    @Override
    public ResponseEntity<AtomicBoolean> validateOrganCodeR2(String organCode) {
        GrpCommonCode grpCommonCode = GrpCommonCode.ORGANCODE_R2;

        GroupCode groupCode = groupCodeRepository.findById(grpCommonCode.getGroupCode())
                .orElseThrow(() -> new BusinessException(ErrorCode.ENTITY_NOT_FOUND));
        return ResponseEntity.ok(groupCode.validate(grpCommonCode.getCommonCode(), organCode));
    }


    @Override
    public ResponseEntity<AtomicBoolean> validateOrganCodeR9(String organCode) {
        GrpCommonCode grpCommonCode = GrpCommonCode.ORGANCODE_R9;

        GroupCode groupCode = groupCodeRepository.findById(grpCommonCode.getGroupCode())
                .orElseThrow(() -> new BusinessException(ErrorCode.ENTITY_NOT_FOUND));
        return ResponseEntity.ok(groupCode.validate(grpCommonCode.getCommonCode(), organCode));
    }

    @Override
    public ResponseEntity<AtomicBoolean> validateOrganCodeM4(String organCode) {
        GrpCommonCode grpCommonCode = GrpCommonCode.ORGANCODE_M4;

        GroupCode groupCode = groupCodeRepository.findById(grpCommonCode.getGroupCode())
                .orElseThrow(() -> new BusinessException(ErrorCode.ENTITY_NOT_FOUND));
        return ResponseEntity.ok(groupCode.validate(grpCommonCode.getCommonCode(), organCode));
    }

    @Override
    public ResponseEntity<AtomicBoolean> validateCardCode(CardCodeValidateDto cardCodeValidateDto) {
        CoopCardCode coopCardCode = coopCardCodeRepository.findById(cardCodeValidateDto.getCoopCardCode())
                .orElseThrow(() -> new BusinessException(ErrorCode.ENTITY_NOT_FOUND));

        return ResponseEntity.ok(coopCardCode.validate(cardCodeValidateDto.getCoopCoCd()
                , cardCodeValidateDto.getIssueMchtNo()));
    }


    @Override
    public ResponseEntity<String> doInterfaceExternalSystem(final CardCodeValidateDto RequestDto) {
        log.debug("[Service] doInterfaceExternalSystem Called - doInterfaceExternalSystem [{}]", RequestDto);

        IExternalSampleSystem externalSampleSystem;


        externalSampleSystem = new ExternalCallSample_Atype();


        //do Some Logic with External System
        return externalSampleSystem.doSomeExternalLogic( RequestDto );
    }

}
