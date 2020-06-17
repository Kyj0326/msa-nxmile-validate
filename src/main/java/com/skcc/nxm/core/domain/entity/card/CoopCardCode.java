package com.skcc.nxm.core.domain.entity.card;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter
public class CoopCardCode {

    @Id
    @Column( name = "coop_crd_cd")
    private String coopCardCode;

    private String hName;

    private String eName;

    private String issueMchtNo;

    private String coopCode;

}
