package org.kpu.myweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.kpu.myweb.domain.CartVO;
import org.kpu.myweb.domain.LoginVO;
import org.kpu.myweb.domain.OrderVO;
import org.kpu.myweb.service.CartService;
import org.kpu.myweb.service.OrderService;
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
@RequestMapping(value="/order")
public class OrderController 
{
	@Autowired
	private CartService cartService;
	
	@Autowired 
	private OrderService orderService;
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String orderProduct(@RequestParam("cartid") int cartid, Model model) throws Exception
	{
		List<CartVO> carts = cartService.readCart(cartid);
		model.addAttribute("carts",carts);
		return "order/product_order";
	}
	
	@RequestMapping(value = {"/"}, method = RequestMethod.POST)
	public String paymentProduct(@ModelAttribute("order") OrderVO ovo, HttpSession session) throws Exception
	{
		LoginVO loginVO = (LoginVO)session.getAttribute("loginVO");
		String cid = loginVO.getId();
		ovo.setCid(cid);
		int amount = ovo.getPprice() * ovo.getCount();
		ovo.setAmount(amount);
		//System.out.println(ovo.getOrderid()+","+ovo.getPnum()+","+ovo.getPname()+","+ovo.getPprice()+","+ovo.getCount()+","+ovo.getAmount()+","+ovo.getCid()+","+ovo.getCusername()+","+ovo.getCaddress()+","+ovo.getCtel());
		try
		{
			orderService.addOrder(ovo);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return "redirect:/order/list";
	}
	
	@RequestMapping(value = {"/delete"}, method = RequestMethod.GET)
	public String deleteProduct(@RequestParam("cartid") int cartid, Model model) throws Exception
	{
		cartService.deleteCart(cartid);
		return "redirect:/cart/";
	}
	
	@RequestMapping(value = {"/list"}, method=RequestMethod.GET)
	public String orderList(Model model, HttpSession session) throws Exception
	{
		LoginVO loginVO = (LoginVO)session.getAttribute("loginVO");
		String cid = loginVO.getId();
		List<OrderVO> order = orderService.readOrderList(cid);
		logger.info(cid);
		model.addAttribute("order", order);
		return "order/order_list";
	}	
}
