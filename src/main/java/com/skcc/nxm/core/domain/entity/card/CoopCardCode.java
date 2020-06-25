package com.skcc.nxm.core.domain.entity.card;

import com.skcc.nxm.core.domain.entity.agree.AgreeVersionRule;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter
public class CoopCardCode {

    @Id
    @Column( name = "coop_crd_cd")
    private String coopCardCode;

    private String hName;

    private String eName;

    private String issueMchtNo;

    @OneToMany( mappedBy = "coopCardCode", cascade = CascadeType.ALL)
    private List<Card> cards = new ArrayList<>();

    @ManyToOne
    @JoinColumn( name = "agr_rule_id")
    private AgreeVersionRule agreeVersionRule;

    public void addCard(Card card){
        cards.add(card);
        card.setCoopCardCode(this);
    }


}
