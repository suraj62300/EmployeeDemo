package com.suraj.trade.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="TradingDetails")
@EntityListeners(AuditingEntityListener.class)
//SYMBOL	SERIES	OPEN	HIGH	LOW	CLOSE	LAST	PREVCLOSE	TOTTRDQTY	TOTTRDVAL	TIMESTAMP	TOTALTRADES	ISIN
public class TradingDetails {
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 private Long id;

	private String symbol;
	
	private String series;
	
	private Double open;
	
	private Double high;
	
	private Double low;
	
	private Double close;
	
	private Double last;
	
	private Double prevclose;
	
	private Long tottrdqty;
	
	private Double tottrdval;
	
	private Date timestamp;
	
	private Long totaltraders;
	
	private String isin;
	
	public TradingDetails() {
		
	}
	
	
	public TradingDetails(String symbol, String series, Double open, Double high, Double low, Double close, Double last,
			Double prevclose, Long tottrdqty, Double tottrdval, Date timestamp, Long totaltraders, String isin) {
		super();
		this.symbol = symbol;
		this.series = series;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.last = last;
		this.prevclose = prevclose;
		this.tottrdqty = tottrdqty;
		this.tottrdval = tottrdval;
		this.timestamp = timestamp;
		this.totaltraders = totaltraders;
		this.isin = isin;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public Double getOpen() {
		return open;
	}
	public void setOpen(Double open) {
		this.open = open;
	}
	public Double getHigh() {
		return high;
	}
	public void setHigh(Double high) {
		this.high = high;
	}
	public Double getLow() {
		return low;
	}
	public void setLow(Double low) {
		this.low = low;
	}
	public Double getClose() {
		return close;
	}
	public void setClose(Double close) {
		this.close = close;
	}
	public Double getLast() {
		return last;
	}
	public void setLast(Double last) {
		this.last = last;
	}
	public Double getPrevclose() {
		return prevclose;
	}

	public void setPrevclose(Double prevclose) {
		this.prevclose = prevclose;
	}

	public Long getTottrdqty() {
		return tottrdqty;
	}
	public void setTottrdqty(Long tottrdqty) {
		this.tottrdqty = tottrdqty;
	}
	public Double getTottrdval() {
		return tottrdval;
	}
	public void setTottrdval(Double tottrdval) {
		this.tottrdval = tottrdval;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public Long getTotaltraders() {
		return totaltraders;
	}
	public void setTotaltraders(Long totaltraders) {
		this.totaltraders = totaltraders;
	}
	public String getIsin() {
		return isin;
	}
	public void setIsin(String isin) {
		this.isin = isin;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TradingDetails [symbol=");
		builder.append(symbol);
		builder.append(", series=");
		builder.append(series);
		builder.append(", open=");
		builder.append(open);
		builder.append(", high=");
		builder.append(high);
		builder.append(", low=");
		builder.append(low);
		builder.append(", close=");
		builder.append(close);
		builder.append(", last=");
		builder.append(last);
		builder.append(", prevclose=");
		builder.append(prevclose);
		builder.append(", tottrdqty=");
		builder.append(tottrdqty);
		builder.append(", tottrdval=");
		builder.append(tottrdval);
		builder.append(", timestamp=");
		builder.append(timestamp);
		builder.append(", totaltraders=");
		builder.append(totaltraders);
		builder.append(", isin=");
		builder.append(isin);
		builder.append("]");
		return builder.toString();
	}
	
}
