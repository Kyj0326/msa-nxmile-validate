package com.skcc.nxm.core.domain.entity.member;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@AllArgsConstructor @NoArgsConstructor
public class OffInfo {

    private String offTelNo;

    private String offZipNo;

    private String offAddr1;

    private String offAddr2;

}
