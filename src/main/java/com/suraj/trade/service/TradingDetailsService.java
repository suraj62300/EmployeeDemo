package com.suraj.trade.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.suraj.trade.model.TradingDetails;


public class TradingDetailsService {

	public static String TYPE = "text/csv";
	public static String[] HEADERs = { "SYMBOL", "SERIES", "OPEN", "HIGH", "LOW", "CLOSE", "LAST", "PREVCLOSE",
			"TOTTRDQTY", "TOTTRDVAL", "TIMESTAMP", "TOTALTRADES", "ISIN" };

	public static boolean hasCSVFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<TradingDetails> csvToEmployee(InputStream is) {
		System.out.println("csvToEmployee start");
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
			List<TradingDetails> tradingDetails = new ArrayList<TradingDetails>();
			System.out.println("tradingDetails sizeeeeeeee" + tradingDetails.size());
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			System.out.println("sizeeeeeeee "+csvParser.getRecordNumber());
			for (CSVRecord csvRecord : csvRecords) {
				//System.out.println("csvRecord "+ csvRecord);
				TradingDetails tradingDetail = new TradingDetails();
				String excelDate = csvRecord.get("TIMESTAMP");
				SimpleDateFormat formatter=new SimpleDateFormat("dd-MMM-yyyy"); 
				Date date=formatter.parse(excelDate);  
				/*TradingDetails tradingDetail = new TradingDetails(csvRecord.get("SYMBOL"), csvRecord.get("SERIES"),
						Double.parseDouble(csvRecord.get("OPEN")), Double.parseDouble(csvRecord.get("HIGH")),
						Double.parseDouble(csvRecord.get("LOW")), Double.parseDouble(csvRecord.get("CLOSE")),
						Double.parseDouble(csvRecord.get("LAST")), Double.parseDouble(csvRecord.get("PREVCLOSE")),
						Long.parseLong(csvRecord.get("TOTTRDQTY")), Double.parseDouble(csvRecord.get("TOTTRDVAL")),
						date, Long.parseLong(csvRecord.get("TOTALTRADES")),
						csvRecord.get("ISIN"));*/
				//System.out.println("date"+ date);
				tradingDetail.setSymbol(csvRecord.get("SYMBOL"));
				tradingDetail.setSeries(csvRecord.get("SERIES"));
				tradingDetail.setOpen(Double.parseDouble(csvRecord.get("OPEN")));
				tradingDetail.setHigh(Double.parseDouble(csvRecord.get("HIGH")));
				tradingDetail.setLow(Double.parseDouble(csvRecord.get("LOW")));
				tradingDetail.setClose(Double.parseDouble(csvRecord.get("CLOSE")));
				tradingDetail.setLast(Double.parseDouble(csvRecord.get("LAST")));
				tradingDetail.setPrevclose(Double.parseDouble(csvRecord.get("PREVCLOSE")));
				tradingDetail.setTottrdqty(Long.parseLong(csvRecord.get("TOTTRDQTY")));
				tradingDetail.setTottrdval(Double.parseDouble(csvRecord.get("TOTTRDVAL")));
				tradingDetail.setTotaltraders(Long.parseLong(csvRecord.get("TOTALTRADES")));
				tradingDetail.setTimestamp(date);
				tradingDetail.setIsin(csvRecord.get("ISIN"));
				
				//System.out.println("tradingDetail "+tradingDetail);
				tradingDetails.add(tradingDetail);
			}
			return tradingDetails;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
		}
	}
}
