package org.kpu.myweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.kpu.myweb.domain.CartVO;
import org.kpu.myweb.domain.LoginVO;
import org.kpu.myweb.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/cart")
public class CartController 
{
	@Autowired
	private CartService cartService;
	
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String listCart(Model model, HttpSession session) throws Exception
	{
		LoginVO loginVO = (LoginVO)session.getAttribute("loginVO");
		String cid = loginVO.getId();
		logger.info(cid);
		List<CartVO> carts = cartService.readCartList(cid);
		model.addAttribute("carts",carts);
		return "cart/cart_list";
	}
	
	@RequestMapping(value = {"/"}, method = RequestMethod.POST)
	public String productCart( @ModelAttribute("cart") CartVO cvo, HttpSession session) throws Exception 
	{	
		LoginVO loginVO = (LoginVO)session.getAttribute("loginVO");
		String cid = loginVO.getId();
		cvo.setCid(cid);
		try
		{
			cartService.addCart(cvo);
			System.out.println("TRANSACTION 처리 완료");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return "cart/product_cart";
	}
}
