package org.kpu.myweb.controller;

import javax.servlet.http.HttpSession;

import org.kpu.myweb.domain.LoginVO;
import org.kpu.myweb.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/login")
public class LoginController 
{
	@Autowired
	private ClientService clientService;
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String loginClient() throws Exception
	{
		return "client/client_login";
	}
	
	@RequestMapping(value = {"/"}, method = RequestMethod.POST)
	public String loginCheck(LoginVO lo, HttpSession session) throws Exception
	{
		try
		{
			LoginVO loginVO = clientService.CheckClient(lo.getId(), lo.getPasswd());
			logger.info(loginVO.getId());
			session.setAttribute("loginVO", loginVO);
			return "redirect:/";
		}
		catch(Exception e)
		{  
			logger.info("fail");
			return "client/client_login";
		}
	}
	
	@RequestMapping(value = {"/fail"}, method = RequestMethod.GET)
	public String loginClientAgain() throws Exception
	{
		return "client/client_fail";
	}
}
