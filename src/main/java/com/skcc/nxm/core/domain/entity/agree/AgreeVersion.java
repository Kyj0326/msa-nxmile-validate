package com.skcc.nxm.core.domain.entity.agree;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter
public class AgreeVersion {

    @Id
    @Column( name = "agr_ver_cd")
    private String agreeVersion;

    private String agreeVersionFlag;

    private String agreeVersionContent;

    private String agreeVersionDetailContent;

    private MarketingFlag marketingFlag;

    @OneToMany(mappedBy = "agreeVersion")
    private List<AgreeVersionInfoAuthority> agreeVersionInfoAuthoritys = new ArrayList<>();

    @OneToMany(mappedBy = "agreeVersion")
    private List<AgreeVersionRule> agreeVersionRules = new ArrayList<>();

    public void addAgreeVersionInfoAuthority(AgreeVersionInfoAuthority agreeVersionInfoAuthority){
        agreeVersionInfoAuthoritys.add(agreeVersionInfoAuthority);
        agreeVersionInfoAuthority.setAgreeVersion(this);
    }

    public void addAgreeVersionRules(AgreeVersionRule agreeVersionRule){
        agreeVersionRules.add(agreeVersionRule);
        agreeVersionRule.setAgreeVersion(this);
    }

}
