package org.kpu.myweb.persistence;

import java.util.List;

import org.kpu.myweb.domain.CartVO;

public interface CartDAO 
{
	public void insert(CartVO cvo) throws Exception;
	public List<CartVO> readCart(int cartid) throws Exception;
	public List<CartVO> readCartList(String cid) throws Exception;
	public void delete(int cartid) throws Exception;
}
