package com.skcc.nxm.core.port_infra.persistent.agree;

import com.skcc.nxm.core.domain.entity.agree.AgreeVersionInfoAuthority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAgreeVersionInfoAuthorityRepository extends JpaRepository<AgreeVersionInfoAuthority, Long> {
}
