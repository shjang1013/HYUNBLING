package org.kpu.myweb.service;

import java.util.List;

import org.kpu.myweb.domain.OrderVO;
import org.kpu.myweb.persistence.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService
{
	@Autowired
	private OrderDAO orderDAO;
	
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, timeout=10)
	public void addOrder(OrderVO ovo) throws Exception
	{
		orderDAO.insert(ovo);
	}
	
	public List<OrderVO> readOrderList(String cid) throws Exception
	{
		return orderDAO.readOrderList(cid);
	}
}
