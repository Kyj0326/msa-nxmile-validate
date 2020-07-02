package com.skcc.nxm.core.domain.entity.member;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.skcc.nxm.core.domain.entity.agree.AgreeVersion;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import sun.util.resources.LocaleData;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity @Getter @Setter
public class MemberAgreeMst {

    @Id @GeneratedValue
    @Column(name = "mbr_agr_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "agr_ver_cd")
    private AgreeVersion agreeVersion;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime agreeDate = LocalDateTime.now();

    private String agrYn;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime firstAgreeDate = LocalDateTime.now();



}
