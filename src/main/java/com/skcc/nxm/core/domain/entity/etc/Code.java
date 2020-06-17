package com.skcc.nxm.core.domain.entity.etc;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Code implements Serializable {

    private String commCode;

    private String arg;

}
