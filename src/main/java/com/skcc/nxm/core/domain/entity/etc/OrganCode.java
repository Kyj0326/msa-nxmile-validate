package com.skcc.nxm.core.domain.entity.etc;

import com.skcc.nxm.core.domain.entity.agree.AgreeVersionRule;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter
public class OrganCode {

    @Id
    @Column(name="organ_cd")
    private String organCode;

    private String organName;

    private String organFlag;


    @OneToMany(mappedBy = "organCode")
    private List<AgreeVersionRule> agreeVersionRules = new ArrayList<>();

    public void addAgreeVersionRule(AgreeVersionRule agreeVersionRule){
        agreeVersionRules.add(agreeVersionRule);
        agreeVersionRule.setOrganCode(this);

    }


}
