package com.skcc.nxm.core.domain.entity.member;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("4")
@Getter
@Setter
public class FamilyMember extends Member {

    private String something;

}
