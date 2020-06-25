package com.skcc.nxm.core.domain.entity.agree;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.skcc.nxm.core.domain.entity.card.CoopCardCode;
import com.skcc.nxm.core.domain.entity.etc.OrganCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter
public class AgreeVersionRule {

    @Id @GeneratedValue
    @Column( name = "agr_rule_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "agr_ver_cd")
    private AgreeVersion agreeVersion;

    @ManyToOne
    @JoinColumn(name = "coop_crd_cd")
    private CoopCardCode coopCardCode;

    @ManyToOne
    @JoinColumn(name = "organ_cd")
    private OrganCode organCode;

    private LocalDateTime validFromDate = LocalDateTime.now();

    private LocalDateTime validToDate = LocalDateTime.now();

}
