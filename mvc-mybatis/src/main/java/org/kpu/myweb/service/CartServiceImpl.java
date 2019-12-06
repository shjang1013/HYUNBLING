package org.kpu.myweb.service;

import java.util.List;

import org.kpu.myweb.domain.BasketVO;
import org.kpu.myweb.domain.CartVO;
import org.kpu.myweb.persistence.CartDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartServiceImpl implements CartService
{
	@Autowired
	private CartDAO cartDAO;
	
	public List<CartVO> readCart(int cartid) throws Exception
	{
		return cartDAO.readCart(cartid);
	}
	
	public List<CartVO> readCartList(String cid) throws Exception
	{
		return cartDAO.readCartList(cid);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, timeout=10)
	public void addCart(CartVO cvo) throws Exception
	{
		cartDAO.insert(cvo);
	}
	
	public void deleteCart(int cartid) throws Exception
	{
		cartDAO.delete(cartid);
	}
	
}
