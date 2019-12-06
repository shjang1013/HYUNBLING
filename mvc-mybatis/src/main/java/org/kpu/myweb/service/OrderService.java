package org.kpu.myweb.service;

import java.util.List;

import org.kpu.myweb.domain.OrderVO;

public interface OrderService 
{
	public void addOrder(OrderVO ovo) throws Exception;
	public List<OrderVO> readOrderList(String cid) throws Exception;
}
