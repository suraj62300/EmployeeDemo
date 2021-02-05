package com.suraj.trade.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.suraj.trade.model.Employee;

public class EmployeeService {

	public static String TYPE = "text/csv";
	public static String[] HEADERs = { "Name", "Designation", "Salary" };
	//public static String SHEET = "Employees";
	
	
	public static boolean hasCSVFormat(MultipartFile file) {

	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }

	    return true;
	  }
	
	public static List<Employee> csvToEmployee(InputStream is) {
	    try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
	        CSVParser csvParser = new CSVParser(fileReader,
	            CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
	      List<Employee> employees = new ArrayList<Employee>();

	      Iterable<CSVRecord> csvRecords = csvParser.getRecords();
	      for (CSVRecord csvRecord : csvRecords) {
	    	  System.out.println("csvRecord "+ csvRecord);
				Employee employee = new Employee(
	              csvRecord.get("Name"),
	              csvRecord.get("Designation"),
	              Double.parseDouble(csvRecord.get("Salary"))
	            );
	    	  employees.add(employee);
	      }
	      return employees;
	    } catch (IOException e) {
	    	e.printStackTrace();
	      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
	    }
	  }
}
