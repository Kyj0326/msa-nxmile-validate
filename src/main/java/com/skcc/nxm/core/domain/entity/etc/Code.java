package com.skcc.nxm.core.domain.entity.etc;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Code {

    @Id
    private String code;

    @ManyToOne
    @JoinColumn( name = "common_code" )
    private CommonCode commonCode;

    private String name;

    private boolean applyYn;

    private boolean defaultYn;

    private LocalDateTime validFromDate = LocalDateTime.now();

    private LocalDateTime validToDate = LocalDateTime.now();

}
