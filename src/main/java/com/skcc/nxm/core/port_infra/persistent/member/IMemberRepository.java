package com.skcc.nxm.core.port_infra.persistent.member;

import com.skcc.nxm.core.domain.entity.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMemberRepository extends JpaRepository<Member, Long> {
}
