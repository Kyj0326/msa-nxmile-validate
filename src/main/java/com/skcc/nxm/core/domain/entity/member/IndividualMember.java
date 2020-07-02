package com.skcc.nxm.core.domain.entity.member;

import com.skcc.nxm.core.domain.entity.agree.AgreeVersion;
import com.skcc.nxm.core.domain.entity.agree.AgreeVersionInfoAuthority;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("1")
@Getter
@Setter
public class IndividualMember extends Member{

    private String ci;

    @OneToMany( mappedBy = "member", fetch = FetchType.LAZY)
    private List<MemberAgreeMst> memberAgreeMsts = new ArrayList<>();


    public void addAgreeVersion(MemberAgreeMst memberAgreeMst){
        memberAgreeMsts.add(memberAgreeMst);
        memberAgreeMst.setMember(this);
    }
}
