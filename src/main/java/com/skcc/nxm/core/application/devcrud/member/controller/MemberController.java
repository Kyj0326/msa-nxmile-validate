package com.skcc.nxm.core.application.devcrud.member.controller;

import com.skcc.common.error.ErrorCode;
import com.skcc.common.error.exception.BusinessException;
import com.skcc.nxm.core.application.devcrud.member.dto.MemberDto;
import com.skcc.nxm.core.domain.entity.agree.AgreeVersion;
import com.skcc.nxm.core.domain.entity.card.Card;
import com.skcc.nxm.core.domain.entity.member.*;
import com.skcc.nxm.core.port_infra.persistent.agree.IAgreeVersionRepository;
import com.skcc.nxm.core.port_infra.persistent.card.ICardRepository;
import com.skcc.nxm.core.port_infra.persistent.member.IMemberAgreeMstRepository;
import com.skcc.nxm.core.port_infra.persistent.member.IMemberRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@RestController
@Profile("dev")
@RequestMapping(value = "/member" )
public class MemberController {

    private final IMemberRepository memberRepository;
    private final ICardRepository cardRepository;
    private final IAgreeVersionRepository agreeVersionRepository;
    private final IMemberAgreeMstRepository memberAgreeMstRepository;

    @PostMapping
    public ResponseEntity<Object> createMember(@RequestBody MemberDto memberDto){

        if( memberDto.getMbrfg().equals("1") ){

            IndividualMember member = new IndividualMember();

            member.setCi(memberDto.getCi());
            member.setHomeInfo(HomeInfo.builder()
                    .homeAddr1(memberDto.getHomeAddr1())
                    .homeAddr2(memberDto.getHomeAddr2())
                    .homeZipNo(memberDto.getOffZipNo())
                    .homeTelNo(memberDto.getHomeTelNo())
                    .build());
            member.setStatus(Status.A);

            Card card = cardRepository.findById("1111111111111111").orElseThrow(() -> new BusinessException("test", ErrorCode.ENTITY_NOT_FOUND));
            member.addCard(card);

            member.setPrivateInfo(PrivateInfo.builder()
                    .hName(memberDto.getHName())
                    .eName(memberDto.getEName())
                    .email(memberDto.getEmail())
                    .birthDay(memberDto.getBirthDay())
                    .sex(memberDto.getSex())
                    .build());

            memberRepository.save(member);

        }

        return ResponseEntity.ok(memberDto);

    }

    @PostMapping(value = "/agree")
    public void createAgree(){
        MemberAgreeMst memberAgreeMst = new MemberAgreeMst();

        memberAgreeMst.setAgrYn("Y");
        memberAgreeMst.setAgreeDate(LocalDateTime.now());
        memberAgreeMst.setFirstAgreeDate(LocalDateTime.now());
        IndividualMember member = (IndividualMember) memberRepository.findById((long) 5).orElseThrow(() -> new BusinessException("test", ErrorCode.ENTITY_NOT_FOUND));
        member.addAgreeVersion(memberAgreeMst);
        AgreeVersion agreeVersion = agreeVersionRepository.findById("NX200624").orElseThrow(() -> new BusinessException("test", ErrorCode.ENTITY_NOT_FOUND));
        agreeVersion.addMemberAgreeMsts(memberAgreeMst);
        memberAgreeMstRepository.save(memberAgreeMst);

    }


}
