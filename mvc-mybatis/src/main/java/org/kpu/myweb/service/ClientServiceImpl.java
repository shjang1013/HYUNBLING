package org.kpu.myweb.service;

import java.util.List;

import org.kpu.myweb.persistence.ClientDAO;
import org.kpu.myweb.domain.ClientVO;
import org.kpu.myweb.domain.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientDAO clientDAO;
	
	public void addClient(ClientVO cvo) throws Exception {
		clientDAO.add(cvo);
	}
	
	public void updateClient(ClientVO cvo) throws Exception
	{
		clientDAO.update(cvo);
	}
	
	public List<ClientVO> readClient(String cid) throws Exception
	{
		return clientDAO.readClient(cid);
	}
	
	public LoginVO CheckClient(String id, String passwd) throws Exception
	{
		LoginVO vo = clientDAO.check(id);
		System.out.println(vo.getId()+","+vo.getPasswd());
		if(vo.getId().compareTo(id) == 0 && vo.getPasswd().compareTo(passwd) == 0)
		{
			System.out.println("YES");
			return vo;
		}
		else
		{
			System.out.println("NO");
			throw new Exception();
		}
	}
}
