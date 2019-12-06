package org.kpu.myweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.kpu.myweb.domain.CartVO;
import org.kpu.myweb.domain.ClientVO;
import org.kpu.myweb.domain.LoginVO;
import org.kpu.myweb.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value="/client")
public class ClientController 
{
	@Autowired
	private ClientService clientService;
	
	private static final Logger logger = LoggerFactory.getLogger(ClientController.class);
	
	// 본인 정보 확인하기 
	@RequestMapping(value = {"/list"}, method = RequestMethod.GET)
	public String listClient(Model model, HttpSession session) throws Exception
	{
		LoginVO loginVO = (LoginVO)session.getAttribute("loginVO");
		String cid = loginVO.getId();
		logger.info(cid);
		List<ClientVO> client = clientService.readClient(cid);
		model.addAttribute("client",client);
		return "client/client_list";
	}
	
	// 본인 정보 수정하기
	@RequestMapping(value = {"/modify"}, method = RequestMethod.GET)
	public String modifyClientGet(@RequestParam("id") String id, Model model) throws Exception
	{
		List<ClientVO> client = clientService.readClient(id);
		model.addAttribute("client",client);
		return "client/client_modify";
	}
	
	@RequestMapping(value = {"/modify"}, method = RequestMethod.POST)
	public String modifyCleintPost(@ModelAttribute("client") ClientVO cvo) throws Exception
	{
		clientService.updateClient(cvo);
		return "redirect:/client/list";
	}

}
