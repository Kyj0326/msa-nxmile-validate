package com.skcc.nxm.core.domain.entity.card;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class CardFetch {

    @Id @GeneratedValue
    @Column(name = "card_fetch_id")
    private Long id;

    @ManyToOne
    @JoinColumn( name = "coop_crd_cd")
    private CoopCardCode coopCardCode;

    private String fetchSeq;

    private String cardMaxNumber;

    private String cardFromNumber;

    private String cardEndNumber;

    private String cycleSeq;

    public void addCoopCardCode(CoopCardCode coopCardCode){
        this.coopCardCode=coopCardCode;
    }

    
}
