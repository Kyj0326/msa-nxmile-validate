package com.skcc.nxm.core.application.devcrud.etc.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CodeReqDto {

    private String groupCode;

    private String commonCode;

    private String code;

    private String name;

}
