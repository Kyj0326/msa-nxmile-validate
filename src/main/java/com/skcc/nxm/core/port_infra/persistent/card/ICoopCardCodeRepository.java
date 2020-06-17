package com.skcc.nxm.core.port_infra.persistent.card;

import com.skcc.nxm.core.domain.entity.card.CoopCardCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICoopCardCodeRepository extends JpaRepository<CoopCardCode, String> {
}
