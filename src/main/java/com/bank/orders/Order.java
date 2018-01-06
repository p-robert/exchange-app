package com.bank.orders;

import java.math.BigDecimal;
import java.util.Calendar;

public class Order {

	private Calendar dateTime;
	private String society;
	private OrderOperation operation;
	private OrderType type;
	private int quantity;
	private BigDecimal price;

	public Order(Calendar dateTime, String society, OrderOperation operation, OrderType type, int quantity,
			BigDecimal price) {
		super();
		this.dateTime = dateTime;
		this.society = society;
		this.operation = operation;
		this.type = type;
		this.quantity = quantity;
		this.price = price;
	}

	public Calendar getDateTime() {
		return dateTime;
	}

	public void setDateTime(Calendar dateTime) {
		this.dateTime = dateTime;
	}

	public String getSociety() {
		return society;
	}

	public void setSociety(String society) {
		this.society = society;
	}

	public OrderOperation getOperation() {
		return operation;
	}

	public void setOperation(OrderOperation operation) {
		this.operation = operation;
	}

	public OrderType getType() {
		return type;
	}

	public void setType(OrderType type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
