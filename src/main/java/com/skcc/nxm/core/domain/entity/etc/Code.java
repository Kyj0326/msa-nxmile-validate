package com.skcc.nxm.core.domain.entity.etc;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Code {

    @Id
    private String code;

    @ManyToOne
    @JoinColumn( name = "commonCode" )
    private CommonCode commonCode;

    private String name;

    private boolean applyYn;

    private boolean defaultYn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime validFromDate = LocalDateTime.now();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime validToDate = LocalDateTime.MAX;

    @PrePersist
    public void prePersist() {
        this.validFromDate = this.validFromDate == null ? LocalDateTime.now() : this.validFromDate;
        this.validToDate = this.validToDate == null ? LocalDateTime.MAX : this.validToDate;
        this.applyYn = true;
    }

}
