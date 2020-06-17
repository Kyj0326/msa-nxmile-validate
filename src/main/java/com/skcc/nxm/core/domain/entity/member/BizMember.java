package com.skcc.nxm.core.domain.entity.member;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
@Getter
@Setter
public class BizMember extends Member {

    private String bizNo;

    private DealerFlag dealerFlag;

}
