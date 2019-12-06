package org.kpu.myweb.persistence;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.kpu.myweb.domain.ClientVO;
import org.kpu.myweb.domain.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ClientDAOImpl implements ClientDAO 
{
	@Autowired
	private SqlSession sqlSession;
	
	private static final String namespace="org.kpu.myweb.mapper.ClientMapper";
	
	public void add(ClientVO cvo) throws Exception 
	{
		sqlSession.insert(namespace + ".insert", cvo);
	}
	
	public void update(ClientVO cvo) throws Exception
	{
		sqlSession.update(namespace + ".update", cvo);
	}
	
	public List<ClientVO> readClient(String cid) throws Exception
	{
		List<ClientVO> client = new ArrayList<ClientVO>();
		client = sqlSession.selectList(namespace + ".select", cid);
		return client;
	}
	
	public LoginVO check(String id) throws Exception
	{
		LoginVO vo = sqlSession.selectOne(namespace + ".check", id);
		return vo;
	}
}
