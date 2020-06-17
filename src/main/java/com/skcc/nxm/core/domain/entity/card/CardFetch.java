package com.skcc.nxm.core.domain.entity.card;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class CardFetch {

    @Id
    private Long id;

    @OneToMany
    @JoinColumn(name = "coop_crd_cd")
    private List<CoopCardCode> coopCardCode = new ArrayList<>();

    private String fetchSeq;

    private String cardMaxNumber;

    private String cardFromNumber;

    private String cardEndNumber;

    private String cycleSeq;
    
}
