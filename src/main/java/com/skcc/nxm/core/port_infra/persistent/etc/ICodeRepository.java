package com.skcc.nxm.core.port_infra.persistent.etc;

import com.skcc.nxm.core.domain.entity.etc.Code;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICodeRepository extends JpaRepository<Code,String> {

}
