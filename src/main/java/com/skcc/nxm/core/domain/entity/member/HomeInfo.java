package com.skcc.nxm.core.domain.entity.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter @AllArgsConstructor @NoArgsConstructor
public class HomeInfo {

    private String homeTelNo;

    private String homeZipNo;

    private String homeAddr1;

    private String homeAddr2;

}
