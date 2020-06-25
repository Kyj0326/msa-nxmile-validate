package com.skcc.nxm.core.domain.entity.etc;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Id
    @Column( name = "common_code")
    private String commonCode;

    @OneToMany( mappedBy = "commonCode" ,fetch = FetchType.EAGER)
    private List<Code> code = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "grpCode")
    private GroupCode grpCode;

    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime validFromDate = LocalDateTime.MAX;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime validToDate = LocalDateTime.MAX;

    private boolean applyYn;

    private boolean defaultYn;

    public void addCode(Code code){
        this.getCode().add(code);
        code.setCommonCode(this);
    }

    @PrePersist
    public void prePersist() {
        this.validFromDate = this.validFromDate == null ? LocalDateTime.now() : this.validFromDate;
        this.validToDate = this.validToDate == null ? LocalDateTime.MAX : this.validToDate;
        this.applyYn = true;
    }

}
