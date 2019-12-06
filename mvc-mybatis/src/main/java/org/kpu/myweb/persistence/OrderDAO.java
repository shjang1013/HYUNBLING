package org.kpu.myweb.persistence;

import java.util.List;

import org.kpu.myweb.domain.OrderVO;

public interface OrderDAO 
{
	public void insert(OrderVO ovo) throws Exception;
	public List<OrderVO> readOrderList(String cid) throws Exception;
}
