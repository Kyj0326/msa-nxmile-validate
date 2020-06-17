package com.skcc.nxm.core.domain.entity.member;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("3")
@Getter
@Setter
public class CorpMember extends Member{

    private String corpBizNo;

    private String bizNo;

}
