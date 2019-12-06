package org.kpu.myweb.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kpu.myweb.domain.OrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDAOImpl implements OrderDAO
{
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.kpu.myweb.mapper.OrderMapper";
	
	public void insert(OrderVO ovo) throws Exception
	{
		sqlSession.insert(namespace + ".insert",ovo);
	}
	
	public List<OrderVO> readOrderList(String cid) throws Exception
	{
		List<OrderVO> orderlist = new ArrayList<OrderVO>();
		orderlist = sqlSession.selectList(namespace + ".select", cid);
		return orderlist;
	}
}
