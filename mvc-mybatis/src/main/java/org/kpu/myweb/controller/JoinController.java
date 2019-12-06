package org.kpu.myweb.controller;

import org.kpu.myweb.domain.ClientVO;
import org.kpu.myweb.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/join")
public class JoinController 
{
	@Autowired
	private ClientService clientService;
	
	private static final Logger logger = LoggerFactory.getLogger(JoinController.class);
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String createClient() throws Exception
	{
		return "client/client_join";
	}	
		
	@RequestMapping(value = {"/"}, method = RequestMethod.POST)
	public String joinClient(@ModelAttribute("client") ClientVO vo) throws Exception
	{
		clientService.addClient(vo);
		logger.info(vo.toString());
		logger.info(" /register URL POST method called. then createMember method executed.");
		return "client/client_join_complete";
	}
}
