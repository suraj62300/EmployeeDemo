package com.suraj.trade.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.suraj.trade.model.TradingDetails;

@Repository
public interface TradingDetailsRepository extends CrudRepository<TradingDetails, Long> {
	
}
