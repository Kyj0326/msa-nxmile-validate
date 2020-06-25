package com.skcc.nxm.core.application.devcrud.card.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CardDto {

    private String cardNo;

    private String cardMaxNumber;

    private String cardFromNumber;

    private String cardEndNumber;

    private String coopCardCode;

    private String koreanName;

    private String englishName;

    private String issueMchtNo;

}
