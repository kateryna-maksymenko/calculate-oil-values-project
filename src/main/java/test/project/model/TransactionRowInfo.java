package test.project.model;

import java.time.LocalDateTime;

public class TransactionRowInfo {
	
	private LocalDateTime createdDate;
	
	private int quantity;
	
	private TransactionType indicator;
	
	private double price;
	
	public TransactionRowInfo(LocalDateTime createdDate, int quantity, TransactionType indicator, double price) {
		this.createdDate = createdDate;
		this.quantity = quantity;
		this.indicator = indicator;
		this.indicator =indicator;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public TransactionType getIndicator() {
		return indicator;
	}

	public void setIndicator(TransactionType indicator) {
		this.indicator = indicator;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	

}
