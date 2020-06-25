package com.skcc.nxm.core.application.devcrud.agree.controller;


import com.skcc.common.error.ErrorCode;
import com.skcc.common.error.exception.BusinessException;
import com.skcc.nxm.core.application.devcrud.agree.dto.AgreeVersionDto;
import com.skcc.nxm.core.domain.entity.agree.AgreeVersion;
import com.skcc.nxm.core.domain.entity.agree.AgreeVersionInfoAuthority;
import com.skcc.nxm.core.domain.entity.agree.AgreeVersionRule;
import com.skcc.nxm.core.domain.entity.agree.MarketingFlag;
import com.skcc.nxm.core.domain.entity.card.CoopCardCode;
import com.skcc.nxm.core.domain.entity.etc.OrganCode;
import com.skcc.nxm.core.port_infra.persistent.agree.IAgreeVersionInfoAuthorityRepository;
import com.skcc.nxm.core.port_infra.persistent.agree.IAgreeVersionRepository;
import com.skcc.nxm.core.port_infra.persistent.agree.IAgreeVersionRuleRepository;
import com.skcc.nxm.core.port_infra.persistent.card.ICoopCardCodeRepository;
import com.skcc.nxm.core.port_infra.persistent.etc.IOrganCodeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
@RestController
@Profile("dev")
@RequestMapping(value = "/agree" )
public class AgreeVersionController {

    private final IAgreeVersionRepository agreeVersionRepository;
    private final IAgreeVersionInfoAuthorityRepository agreeVersionInfoAuthorityRepository;
    private final IAgreeVersionRuleRepository agreeVersionRuleRepository;
    private final ICoopCardCodeRepository coopCardCodeRepository;
    private final IOrganCodeRepository organCodeRepository;


    @PostMapping
    public ResponseEntity<Object> createAgreeVersion(@RequestBody AgreeVersionDto agreeVersionDto){

        AgreeVersion agreeVersion = new AgreeVersion();

        agreeVersion.setAgreeVersion(agreeVersionDto.getAgreeVersion());
        agreeVersion.setMarketingFlag(agreeVersionDto.getMarketingFlag());
        agreeVersion.setAgreeVersionFlag(agreeVersionDto.getAgreeVersionFlag());

        agreeVersionRepository.save(agreeVersion);

        AgreeVersionInfoAuthority agreeVersionInfoAuthority = new AgreeVersionInfoAuthority();

        agreeVersionInfoAuthority.setItemCode(agreeVersionDto.getItemCode());
        agreeVersion.addAgreeVersionInfoAuthority(agreeVersionInfoAuthority);
        agreeVersionInfoAuthorityRepository.save(agreeVersionInfoAuthority);

        AgreeVersionRule agreeVersionRule = new AgreeVersionRule();

        CoopCardCode coopCardCode = coopCardCodeRepository.findById(agreeVersionDto.getCoopCardCode())
                                .orElseThrow(() -> new BusinessException("CoopCardCodeNotFound", ErrorCode.ENTITY_NOT_FOUND));

        OrganCode organCode = organCodeRepository.findById(agreeVersionDto.getOrganCode())
                                .orElseThrow(() -> new BusinessException("OrganCode NotFound", ErrorCode.ENTITY_NOT_FOUND));

        agreeVersion.addAgreeVersionRules(agreeVersionRule);
        coopCardCode.addAgreeVersionRule(agreeVersionRule);
        organCode.addAgreeVersionRule(agreeVersionRule);

        agreeVersionRuleRepository.save(agreeVersionRule);


        return ResponseEntity.ok(agreeVersionDto);

    }


    @PostMapping(value = "/test")
    public void createAgreeVersion(){

        AgreeVersion agreeVersion = new AgreeVersion();

        agreeVersion.setAgreeVersion("DB200625");
        agreeVersion.setMarketingFlag(MarketingFlag.IM);
        agreeVersion.setAgreeVersionFlag("3");

        agreeVersionRepository.save(agreeVersion);

    }

    @PostMapping(value = "/test2")
    public void createAgreeVersion2(){

        AgreeVersionInfoAuthority agreeVersionInfoAuthority = new AgreeVersionInfoAuthority();

        agreeVersionInfoAuthority.setItemCode("RESD001");

        AgreeVersion agreeVersion = agreeVersionRepository.findById("DB200625").orElseThrow(() -> new BusinessException("TEST", ErrorCode.ENTITY_NOT_FOUND));
        agreeVersion.addAgreeVersionInfoAuthority(agreeVersionInfoAuthority);
        agreeVersionInfoAuthorityRepository.save(agreeVersionInfoAuthority);

    }



    @PostMapping(value = "/test3")
    public void createAgreeVersion3(){

        AgreeVersionRule agreeVersionRule = new AgreeVersionRule();

        CoopCardCode coopCardCode = coopCardCodeRepository.findById("A001")
                .orElseThrow(() -> new BusinessException("CoopCardCodeNotFound", ErrorCode.ENTITY_NOT_FOUND));

        OrganCode organCode = organCodeRepository.findById("7065")
                .orElseThrow(() -> new BusinessException("OrganCode NotFound", ErrorCode.ENTITY_NOT_FOUND));

        coopCardCode.addAgreeVersionRule(agreeVersionRule);
        organCode.addAgreeVersionRule(agreeVersionRule);

        agreeVersionRuleRepository.save(agreeVersionRule);


    }

//    @PostMapping
//    public ResponseEntity<Object> createAgreeVersion(@RequestBody AgreeVersionDto agreeVersionDto){
//
//        AgreeVersion agreeVersion = new AgreeVersion();
//
//        agreeVersion.setAgreeVersion(agreeVersion.getAgreeVersion());
//        agreeVersion.setAgreeVersionFlag(agreeVersion.getAgreeVersionFlag());
//        agreeVersion.setMarketingFlag(agreeVersion.getMarketingFlag());
//
//        AgreeVersionRule agreeVersionRule = new AgreeVersionRule();
//        agreeVersionRule.getAgreeVersion().add(agreeVersion);
//        agreeVersionRule.getCoopCardCode().add(coopCardCodeRepository.getOne(agreeVersionDto.getCoopCardCode()));
//        agreeVersionRule.getOrganCode().add(organCodeRepository.getOne(agreeVersionDto.getOrganCode()));
//
//        AgreeVersionInfoAuthority agreeVersionInfoAuthority = new AgreeVersionInfoAuthority();
//        agreeVersionInfoAuthority.setAgreeVersion(agreeVersion);
//        agreeVersionInfoAuthority.setItemCode(agreeVersionDto.getItemCode());
//
//        AgreeVersion save = agreeVersionRepository.save(agreeVersion);
//        AgreeVersionInfoAuthority save1 = agreeVersionInfoAuthorityRepository.save(agreeVersionInfoAuthority);
//        AgreeVersionRule save2 = agreeVersionRuleRepository.save(agreeVersionRule);
//
//        return ResponseEntity.ok(agreeVersionDto);
//
//    }


//    @GetMapping("/{agreeVersion}")
//    public ResponseEntity<Object> getAgreeVersion(@PathVariable String agreeVersion){
//
//        agreeVersionRepository.findById(agreeVersion);
//        agreeVersionRuleRepository.findByAgreeVersion(agreeVersion);
//        agreeVersionInfoAuthorityRepository.findByAgreeVersion(agreeVersion);
//
//        return ResponseEntity.ok(agreeVersionRepository.findById(agreeVersion));
//
//    }


}
