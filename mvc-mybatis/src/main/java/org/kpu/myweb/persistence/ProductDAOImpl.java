package org.kpu.myweb.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kpu.myweb.domain.BasketVO;
import org.kpu.myweb.domain.ProductVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO
{
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace = "org.kpu.myweb.mapper.ProductMapper";

	public List<ProductVO> readList(int num) throws Exception
	{
		List<ProductVO> productlist = new ArrayList<ProductVO>();
		productlist = sqlSession.selectList(namespace + ".select", num);
		return productlist;
	}
	
	public List<BasketVO> readbasketList() throws Exception
	{
		List<BasketVO> basketlist = new ArrayList<BasketVO>();
		basketlist = sqlSession.selectList(namespace + ".selectbasketAll");
		return basketlist;
	}
	
	public void insert(BasketVO bvo) throws Exception
	{
		sqlSession.insert(namespace + ".insert", bvo);
	}
	
	public void update(BasketVO bvo) throws Exception
	{		
		sqlSession.update(namespace + ".update", bvo);
	}
}
