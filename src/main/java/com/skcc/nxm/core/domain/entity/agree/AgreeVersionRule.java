package com.skcc.nxm.core.domain.entity.agree;

import com.skcc.nxm.core.domain.entity.card.CoopCardCode;
import com.skcc.nxm.core.domain.entity.etc.OrganCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter
public class AgreeVersionRule {

    @Id
    @Column( name = "agr_rule_id")
    private Long id;

    @OneToMany
    @JoinColumn( name = "agr_ver_cd")
    private List<AgreeVersion> agreeVersion = new ArrayList<>();

    @OneToMany
    @JoinColumn( name = "coop_crd_cd")
    private List<CoopCardCode> coopCardCode = new ArrayList<>();

    @OneToMany
    @JoinColumn( name = "organ_cd")
    private List<OrganCode> organCode = new ArrayList<>();

    private String applyFromDate;

    private String applyToDate;


}
