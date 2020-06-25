package com.skcc.nxm.core.port_infra.persistent.etc;

import com.skcc.nxm.core.domain.entity.etc.CommonCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommonCodeRepository extends JpaRepository<CommonCode,String> {
}
