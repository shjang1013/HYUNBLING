package org.kpu.myweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/logout")
public class LogoutController 
{
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String logoutClient(HttpSession session) throws Exception
	{
		session.invalidate();
		return "client/client_logout";
	}
}
