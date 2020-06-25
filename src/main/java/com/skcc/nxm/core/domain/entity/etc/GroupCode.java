package com.skcc.nxm.core.domain.entity.etc;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
@Entity
public class GroupCode {

    @Id
    @Column(name = "grpCode")
    private String grpCode;

    @OneToMany(mappedBy = "grpCode", fetch = FetchType.EAGER)
    private Set<CommonCode> commonCodes = new HashSet<>();

    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime validFromDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime validToDate;

    private boolean applyYn;

    public void addCommonCode(CommonCode commonCode){
        this.getCommonCodes().add(commonCode);
        commonCode.setGrpCode(this);
    }

    @PrePersist
    public void prePersist() {
        this.validFromDate = this.validFromDate == null ? LocalDateTime.now() : this.validFromDate;
        this.validToDate = this.validToDate == null ? LocalDateTime.MAX : this.validToDate;
        this.applyYn = true;
    }


}
