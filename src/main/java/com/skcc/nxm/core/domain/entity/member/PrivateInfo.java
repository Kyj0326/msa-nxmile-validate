package com.skcc.nxm.core.domain.entity.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter @AllArgsConstructor @NoArgsConstructor
public class PrivateInfo {

    private String hName;

    private String eName;

    private String email;

    private String birthDay;

    private String phoneNumber;

    private String sex;




}
