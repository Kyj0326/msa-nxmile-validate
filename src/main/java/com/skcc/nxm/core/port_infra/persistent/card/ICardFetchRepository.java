package com.skcc.nxm.core.port_infra.persistent.card;

import com.skcc.nxm.core.domain.entity.card.CardFetch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICardFetchRepository extends JpaRepository<CardFetch, Long> {
}
