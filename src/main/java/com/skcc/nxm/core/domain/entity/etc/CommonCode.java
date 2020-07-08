package com.skcc.nxm.core.domain.entity.etc;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
@Entity
public class CommonCode {

    @Id @GeneratedValue
    @Column(name = "commonCode_id")
    private Long id;

    @Column( name = "common_code")
    private String  commonCode;

    @OneToMany( mappedBy = "commonCode" ,fetch = FetchType.EAGER)
    private List<Code> codes = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "grpCode")
    private GroupCode grpCode;

    private String name;

    private LocalDateTime validFromDate = LocalDateTime.now();

    private LocalDateTime validToDate = LocalDateTime.now();

    private boolean applyYn;

    private boolean defaultYn;

    public void addCode(Code code){
        this.getCodes().add(code);
        code.setCommonCode(this);
    }

}
