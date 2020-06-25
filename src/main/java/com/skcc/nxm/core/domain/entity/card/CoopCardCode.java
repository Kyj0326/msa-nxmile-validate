package com.skcc.nxm.core.domain.entity.card;

import com.skcc.nxm.core.domain.entity.agree.AgreeVersion;
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

    @OneToMany( mappedBy = "coopCardCode", cascade = CascadeType.ALL)
    private List<AgreeVersionRule> agreeVersionRules = new ArrayList<>();

    public void addCard(Card card){
        cards.add(card);
        card.setCoopCardCode(this);
    }

    public void addAgreeVersionRule(AgreeVersionRule agreeVersionRule){
        agreeVersionRules.add(agreeVersionRule);
        agreeVersionRule.setCoopCardCode(this);
    }


}
