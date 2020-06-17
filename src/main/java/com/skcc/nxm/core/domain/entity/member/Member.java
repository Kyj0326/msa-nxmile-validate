package com.skcc.nxm.core.domain.entity.member;

import com.skcc.nxm.core.domain.entity.card.Card;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "mbr_fg")
public abstract class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String ci;

    @OneToMany( mappedBy = "member" )
    private List<Card> card = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Status status;

    @Embedded
    private PrivateInfo privateInfo;

    @Embedded
    private HomeInfo homeInfo;

    @Embedded
    private OffInfo offInfo;

}
