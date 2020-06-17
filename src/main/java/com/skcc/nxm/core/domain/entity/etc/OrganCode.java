package com.skcc.nxm.core.domain.entity.etc;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity @Getter @Setter
public class OrganCode {

    @Id
    @Column(name="organ_cd")
    private String organCode;

    private String organName;

    private String organFlag;

}
