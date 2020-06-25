package com.skcc.nxm.core.application.devcrud.agree.dto;

import com.skcc.nxm.core.domain.entity.agree.MarketingFlag;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AgreeVersionDto {

    private String agreeVersion;

    private String agreeVersionFlag;

    private MarketingFlag marketingFlag;

    private String itemCode;

    private String coopCardCode;

    private String organCode;

}
