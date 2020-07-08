package com.skcc.nxm.core.application.object.command;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CardCodeValidateDto {

    private String coopCardCode;

    private String coopCoCd;

    private String issueMchtNo;

}
