package com.skcc.nxm.core.application.devcrud.member.dto;


import com.skcc.nxm.core.domain.entity.member.DealerFlag;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MemberDto {

    private String mbrfg;

    private String ci;

    private String bizNo;

    private String dealerFlag;

    private String corpBizNo;

    private String hName;

    private String eName;

    private String email;

    private String birthDay;

    private String phoneNumber;

    private String sex;

    private String homeTelNo;

    private String homeZipNo;

    private String homeAddr1;

    private String homeAddr2;

    private String offTelNo;

    private String offZipNo;

    private String offAddr1;

    private String offAddr2;

}
