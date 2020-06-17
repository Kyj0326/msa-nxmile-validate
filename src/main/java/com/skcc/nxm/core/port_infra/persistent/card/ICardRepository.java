package com.skcc.nxm.core.port_infra.persistent.card;

import com.skcc.nxm.core.domain.entity.card.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICardRepository extends JpaRepository<Card , String> {
}
