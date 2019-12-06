package org.kpu.myweb.service;

import java.util.List;

import org.kpu.myweb.domain.ClientVO;
import org.kpu.myweb.domain.LoginVO;

public interface ClientService 
{
	public void addClient(ClientVO cvo) throws Exception;
	public List<ClientVO> readClient(String cid) throws Exception;
	public LoginVO CheckClient(String id, String passwd) throws Exception;
	public void updateClient(ClientVO cvo) throws Exception;
}
