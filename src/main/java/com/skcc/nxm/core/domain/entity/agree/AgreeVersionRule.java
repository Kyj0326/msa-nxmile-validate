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

    @Id
    @Column( name = "agr_rule_id")
    private Long id;

    @OneToMany( mappedBy = "agreeVersionRule" )
    private List<AgreeVersion> agreeVersions = new ArrayList<>();

    @OneToMany( mappedBy = "agreeVersionRule")
    private List<CoopCardCode> coopCardCodes = new ArrayList<>();

    @OneToMany( mappedBy = "agreeVersionRule")
    private List<OrganCode> organCodes = new ArrayList<>();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime validFromDate = LocalDateTime.MAX;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime validToDate = LocalDateTime.MAX;

    @PrePersist
    public void prePersist() {
        this.validFromDate = this.validFromDate == null ? LocalDateTime.now() : this.validFromDate;
        this.validToDate = this.validToDate == null ? LocalDateTime.MAX : this.validToDate;
    }

    public void addAgreeVersion(AgreeVersion agreeVersion){
        agreeVersions.add(agreeVersion);
        agreeVersion.setAgreeVersionRule(this);
    }

    public void addCoopCardCode(CoopCardCode coopCardCode){
        coopCardCodes.add(coopCardCode);
        coopCardCode.setAgreeVersionRule(this);
    }

    public void addOrganCode(OrganCode organCode){
        organCodes.add(organCode);
        organCode.setAgreeVersionRule(this);
    }

}
