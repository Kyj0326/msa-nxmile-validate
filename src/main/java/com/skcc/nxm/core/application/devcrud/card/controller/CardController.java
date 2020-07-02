package com.skcc.nxm.core.application.devcrud.card.controller;


import com.skcc.common.error.ErrorCode;
import com.skcc.common.error.exception.BusinessException;
import com.skcc.nxm.core.application.devcrud.card.dto.CardDto;
import com.skcc.nxm.core.domain.entity.card.Card;
import com.skcc.nxm.core.domain.entity.card.CardFetch;
import com.skcc.nxm.core.domain.entity.card.CoopCardCode;
import com.skcc.nxm.core.domain.entity.card.Status;
import com.skcc.nxm.core.port_infra.persistent.card.ICardFetchRepository;
import com.skcc.nxm.core.port_infra.persistent.card.ICardRepository;
import com.skcc.nxm.core.port_infra.persistent.card.ICoopCardCodeRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;

@Slf4j
@AllArgsConstructor
@RestController
@Profile("dev")
@RequestMapping(value = "/card" )
public class CardController {


    private final ICardFetchRepository cardFetchRepository;
    private final ICardRepository cardRepository;
    private final ICoopCardCodeRepository coopCardCodeRepository;


    @PostMapping
    public ResponseEntity<Object> createCard(@RequestBody CardDto cardDto){

        Card card = new Card();

        card.setStatus(Status.A);
        card.setCardNo(cardDto.getCardNo());
        cardRepository.save(card);

        CoopCardCode coopCardCode = new CoopCardCode();
        coopCardCode.setCoopCardCode(cardDto.getCoopCardCode());
        coopCardCode.setIssueMchtNo(cardDto.getIssueMchtNo());
        coopCardCode.setEName(cardDto.getKoreanName());
        coopCardCode.setHName(cardDto.getEnglishName());

        coopCardCode.addCard(card);

        coopCardCodeRepository.save(coopCardCode);

        CardFetch cardFetch = new CardFetch();

        cardFetch.setCardFromNumber(cardDto.getCardFromNumber());
        cardFetch.setCardEndNumber(cardDto.getCardEndNumber());
        cardFetch.setCardMaxNumber(cardDto.getCardMaxNumber());

        cardFetch.addCoopCardCode(coopCardCode);


        cardFetchRepository.save(cardFetch);


        return ResponseEntity.ok(cardDto);

    }

    @PostMapping(value = "/test")
    public void test(){

        Card card = new Card();

        card.setCardNo("1111111111111111");
        card.setIssueDay("20200624");
        card.setStatus(Status.A);

        cardRepository.save(card);

    }

    @PostMapping(value = "/test2")
    public void test22(){

      CoopCardCode coopCardCode = new CoopCardCode();

      coopCardCode.setHName("TEST");
        coopCardCode.setEName("TEST");
        coopCardCode.setCoopCardCode("A001");
        coopCardCode.setIssueMchtNo("99999999");
        Card test = cardRepository.findById("1111111111111111").orElseThrow(() -> new BusinessException("TEST", ErrorCode.ENTITY_NOT_FOUND));
        log.info(test.getCardNo());
        coopCardCode.addCard(test);

        coopCardCodeRepository.save(coopCardCode);

    }

    @PostMapping(value = "/test3")
    public void test33(){

        CardFetch cardFetch = new CardFetch();

        cardFetch.setCardFromNumber("88000000");
        cardFetch.setCardEndNumber("88999999");
        cardFetch.setCardMaxNumber("88999999");

        CoopCardCode coopCardCode = coopCardCodeRepository.findById("A001").orElseThrow(() -> new BusinessException("TEST", ErrorCode.ENTITY_NOT_FOUND));
        cardFetch.addCoopCardCode(coopCardCode);

       cardFetchRepository.save(cardFetch);

        CardFetch cardFetch2 = new CardFetch();

        cardFetch2.setCardFromNumber("77000000");
        cardFetch2.setCardEndNumber("77999999");
        cardFetch2.setCardMaxNumber("77999999");

        CoopCardCode coopCardCode2 = coopCardCodeRepository.findById("A001").orElseThrow(() -> new BusinessException("TEST", ErrorCode.ENTITY_NOT_FOUND));
        cardFetch2.addCoopCardCode(coopCardCode2);

        cardFetchRepository.save(cardFetch2);

    }
}
