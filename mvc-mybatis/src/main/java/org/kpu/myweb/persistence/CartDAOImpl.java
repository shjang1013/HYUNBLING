package org.kpu.myweb.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kpu.myweb.domain.CartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDAOImpl implements CartDAO
{
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.kpu.myweb.mapper.CartMapper";
	
	public List<CartVO> readCart(int cartid) throws Exception
	{
		List<CartVO> cart = new ArrayList<CartVO>();
		cart = sqlSession.selectList(namespace + ".cart", cartid);
		return cart;
	}
	
	public List<CartVO> readCartList(String cid) throws Exception
	{
		List<CartVO> cartlist = new ArrayList<CartVO>();
		cartlist = sqlSession.selectList(namespace + ".select", cid);
		return cartlist;
	}
	
	public void insert(CartVO cvo) throws Exception
	{
		sqlSession.insert(namespace + ".insert",cvo);
	}
	
	public void delete(int cartid) throws Exception
	{
		sqlSession.delete(namespace + ".delete", cartid);
	}
}
