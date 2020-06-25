package com.skcc.nxm.core.port_infra.persistent.agree;

import com.skcc.nxm.core.domain.entity.agree.AgreeVersionRule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAgreeVersionRuleRepository extends JpaRepository<AgreeVersionRule, Long> {

    //List<AgreeVersionRule> findByAgreeVersion(String agreeVersion);
}
