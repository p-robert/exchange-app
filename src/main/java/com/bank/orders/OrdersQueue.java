package com.bank.orders;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class OrdersQueue {

	private static Map<String, TreeSet<Order>> ordersMap = new HashMap<String, TreeSet<Order>>();

	public static Map<String, TreeSet<Order>> getOrdersSet() {
		return Collections.unmodifiableMap(ordersMap);
	}

	public static void addOrder(String societyName, Order order) {
		
	}
}
