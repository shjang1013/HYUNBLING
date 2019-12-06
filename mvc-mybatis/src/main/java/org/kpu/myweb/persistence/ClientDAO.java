package org.kpu.myweb.persistence;

import java.util.List;

import org.kpu.myweb.domain.ClientVO;
import org.kpu.myweb.domain.LoginVO;

public interface ClientDAO {
	public void add(ClientVO cvo) throws Exception;
	public void update(ClientVO cvo) throws Exception;
	public List<ClientVO> readClient(String cid) throws Exception;
	public LoginVO check(String id) throws Exception;
}
