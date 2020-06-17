package com.skcc.nxm.core.port_infra.persistent.agree;

import com.skcc.nxm.core.domain.entity.agree.AgreeVersion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAgreeVersionRepository extends JpaRepository<AgreeVersion, String> {
}
