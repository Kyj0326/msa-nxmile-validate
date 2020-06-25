package com.skcc.nxm.core.port_infra.persistent.etc;

import com.skcc.nxm.core.domain.entity.etc.OrganCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrganCodeRepository extends JpaRepository<OrganCode,String> {
}
