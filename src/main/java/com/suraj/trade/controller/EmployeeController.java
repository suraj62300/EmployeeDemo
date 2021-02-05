package com.suraj.trade.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.suraj.trade.dao.EmployeeDAO;
import com.suraj.trade.dao.TradingDetailsDAO;
import com.suraj.trade.message.ResponseMessage;
import com.suraj.trade.model.Employee;
import com.suraj.trade.model.TradingDetails;
import com.suraj.trade.service.EmployeeService;
import com.suraj.trade.service.TradingDetailsService;

@RestController
@RequestMapping("/company")
public class EmployeeController {

	@Autowired
	EmployeeDAO employeeDAO;
	@Autowired
	TradingDetailsDAO tradingDetailsDAO;
	
	/* to save an employee */
	@PostMapping("/saveEmployee")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		return employeeDAO.save(emp);
	}
	
	/* to get all employees */
	@GetMapping("/getEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		try {
			List<Employee> employees = employeeDAO.getAllEmployees();

			if (employees.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(employees, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/uploadEmployeeData")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";

		if (EmployeeService.hasCSVFormat(file)) {
			try {
				employeeDAO.save(file);

				message = "Uploaded the file successfully: " + file.getOriginalFilename();
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} catch (Exception e) {
				message = "Could not upload the file: " + file.getOriginalFilename() + "!";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}
		}

		message = "Please upload a csv file!";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	}
	
	/* to get all tradeData */
	@GetMapping("/getTradeData")
	public ResponseEntity<List<TradingDetails>> getAllTradingData() {
		try {
			List<TradingDetails> tradingDetails = tradingDetailsDAO.getAllTradingData();

			if (tradingDetails.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(tradingDetails, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/uploadTradeData")
	public ResponseEntity<ResponseMessage> uploadTradingFile(@RequestParam("file") MultipartFile file) {
		String message = "";

		if (TradingDetailsService.hasCSVFormat(file)) {
			try {
				tradingDetailsDAO.save(file);

				message = "Uploaded the file successfully: " + file.getOriginalFilename();
				return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
			} catch (Exception e) {
				message = "Could not upload the file: " + file.getOriginalFilename() + "!";
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}
		}

		message = "Please upload a csv file!";
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
	}

}
