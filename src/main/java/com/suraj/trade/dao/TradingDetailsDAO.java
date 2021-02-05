package com.suraj.trade.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.suraj.trade.model.Employee;
import com.suraj.trade.model.TradingDetails;
import com.suraj.trade.repository.TradingDetailsRepository;
import com.suraj.trade.service.TradingDetailsService;

@Service
public class TradingDetailsDAO {
	
	@Autowired
	TradingDetailsRepository tradingDetailsRepository;

	public void save(MultipartFile file) {
		try {
			System.out.println("TradingDetailsDAO Class || save");
			List<TradingDetails> tradingDetails = TradingDetailsService.csvToEmployee(file.getInputStream());
			System.out.println("tradingDetails size " + tradingDetails.size());
			Iterable entities = tradingDetails;
			//List<TradingDetails> saveAll = tradingDetailsRepository.saveAll(tradingDetails);
			List<TradingDetails> saveAll = (List<TradingDetails>) tradingDetailsRepository.saveAll(entities);
			System.out.println("tradingDetails saved  " + saveAll);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("fail to store csv data: " + e.getMessage());
		}
	}
	
	/* to search all Employee */
	public List<TradingDetails> getAllTradingData(){
		return (List<TradingDetails>) tradingDetailsRepository.findAll();
	}
}
