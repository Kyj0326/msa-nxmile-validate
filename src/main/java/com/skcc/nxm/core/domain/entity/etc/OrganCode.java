package com.skcc.nxm.core.domain.entity.etc;

import com.skcc.nxm.core.domain.entity.agree.AgreeVersionRule;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter
public class OrganCode {

    @Id
    @Column(name="organ_cd")
    private String organCode;

    private String organName;

    private String organFlag;

    @ManyToOne
    @JoinColumn( name = "agr_rule_id")
    private AgreeVersionRule agreeVersionRule;

}
