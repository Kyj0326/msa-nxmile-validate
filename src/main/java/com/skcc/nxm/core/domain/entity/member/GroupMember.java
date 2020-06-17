package com.skcc.nxm.core.domain.entity.member;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("5")
@Getter
@Setter
public class GroupMember extends Member{

    private String something;
}
