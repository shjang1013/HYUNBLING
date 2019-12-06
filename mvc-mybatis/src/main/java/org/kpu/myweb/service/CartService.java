package org.kpu.myweb.service;

import java.util.List;

import org.kpu.myweb.domain.CartVO;

public interface CartService 
{
	public void addCart(CartVO cvo) throws Exception;
	public List<CartVO> readCart(int cartid) throws Exception;
	public List<CartVO> readCartList(String cid) throws Exception;
	public void deleteCart(int cartid) throws Exception;
}
