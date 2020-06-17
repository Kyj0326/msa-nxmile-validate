package com.skcc.nxm.core.domain.entity.card;

import com.skcc.nxm.core.domain.entity.member.Member;

import javax.persistence.*;

@Entity
public class Card {

    @Id
    @Column(name = "card_no" )
    private String cardNo;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "member_id" )
    private Member member;

    @ManyToOne( fetch = FetchType.LAZY )
    @JoinColumn( name = "coop_crd_cd" )
    private CoopCardCode coopCardCode;

    private String issueDay;

    private Status status;


}
