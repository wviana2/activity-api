package com.fmv.reg.misc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Override
	public List<String> getOrders() {
		List<String> orders = new ArrayList<String>();
		orders.add("Breakfast");
		orders.add("Lunch");
		return orders;
	}

}
