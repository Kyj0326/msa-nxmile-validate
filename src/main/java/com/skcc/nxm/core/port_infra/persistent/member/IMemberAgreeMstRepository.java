package com.skcc.nxm.core.port_infra.persistent.member;

import com.skcc.nxm.core.domain.entity.member.MemberAgreeMst;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMemberAgreeMstRepository extends JpaRepository<MemberAgreeMst, Long> {

}
