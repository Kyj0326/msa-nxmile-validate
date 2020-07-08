package com.skcc.nxm.core.domain.entity.etc;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
@Entity
@Slf4j
public class GroupCode {

    @Id
    @Column(name = "grpCode")
    private String grpCode;

    @OneToMany(mappedBy = "grpCode", fetch = FetchType.EAGER)
    private List<CommonCode> commonCodes = new ArrayList<>();

    private String name;

    private LocalDateTime validFromDate = LocalDateTime.now();

    private LocalDateTime validToDate = LocalDateTime.now();

    private boolean applyYn;

    public void addCommonCode(CommonCode commonCode){
        this.getCommonCodes().add(commonCode);
        commonCode.setGrpCode(this);
    }

    public AtomicBoolean validate(String commonCode, String code){
        List<CommonCode> commonCodes = new ArrayList<>();
        AtomicBoolean result = new AtomicBoolean(false);

        this.commonCodes.forEach(e-> {
            boolean equals = e.getCommonCode().equals(commonCode);
            if(equals==true){
                commonCodes.add(e);
            }});
        commonCodes.forEach(e->{
            e.getCodes().stream().filter(a -> a.getCode().equals(code)).map(a -> true).forEach(result::set);
        });
        return result;
    }


}
