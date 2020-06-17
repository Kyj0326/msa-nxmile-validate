package com.skcc.nxm.core.domain.entity.agree;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity @Getter @Setter
public class AgreeVersion {

    @Id
    @Column( name = "agr_ver_cd")
    private String agreeVersion;

    private String agreeVersionFlag;

    private String agreeVersionContent;

    private String agreeVersionDetailContent;

    private MarketingFlag marketingFlag;

}
