package org.kpu.myweb.controller;

import java.util.List;

import org.kpu.myweb.domain.BasketVO;
import org.kpu.myweb.domain.ProductVO;
import org.kpu.myweb.service.ProductService;
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
@RequestMapping(value="/product")
public class ProductContoller 
{
	@Autowired
    private ProductService productService;
	
	@RequestMapping(value = {"/best"}, method = RequestMethod.GET)
	public String showProductBest() throws Exception
	{
		return "product/product_best";
	}
	
	@RequestMapping(value = {"/earing"}, method = RequestMethod.GET)
	public String showProductEaring() throws Exception
	{
		return "product/product_earing";
	}
	
	@RequestMapping(value = {"/ring"}, method = RequestMethod.GET)
	public String showProductRing() throws Exception
	{
		return "product/product_ring";
	}
	
	@RequestMapping(value = {"/etc"}, method = RequestMethod.GET)
	public String showProductEtc() throws Exception
	{
		return "product/product_etc";
	}
	
	@RequestMapping(value = {"/show1"}, method = RequestMethod.GET)
	public String showProduct1(Model model) throws Exception
	{
		int num = 1;
		List<ProductVO> products = productService.readProductList(num);
		model.addAttribute("products", products);
		return "product/product1";
	}
	
	@RequestMapping(value = {"/show2"}, method = RequestMethod.GET)
	public String showProduct2(Model model) throws Exception
	{
		int num = 2;
		List<ProductVO> products = productService.readProductList(num);
		model.addAttribute("products", products);
		return "product/product2";
	}
	
	@RequestMapping(value = {"/show3"}, method = RequestMethod.GET)
	public String showProduct3(Model model) throws Exception
	{
		int num = 3;
		List<ProductVO> products = productService.readProductList(num);
		model.addAttribute("products", products);
		return "product/product3";
	}
	
	@RequestMapping(value = {"/show4"}, method = RequestMethod.GET)
	public String showProduct4(Model model) throws Exception
	{
		int num = 4;
		List<ProductVO> products = productService.readProductList(num);
		model.addAttribute("products", products);
		return "product/product4";
	}
	
	@RequestMapping(value = {"/show5"}, method = RequestMethod.GET)
	public String showProduct5(Model model) throws Exception
	{
		int num = 5;
		List<ProductVO> products = productService.readProductList(num);
		model.addAttribute("products", products);
		return "product/product5";
	}
	
	@RequestMapping(value = {"/show6"}, method = RequestMethod.GET)
	public String showProduct6(Model model) throws Exception
	{
		int num = 6;
		List<ProductVO> products = productService.readProductList(num);
		model.addAttribute("products", products);
		return "product/product6";
	}
	
	@RequestMapping(value = {"/show7"}, method = RequestMethod.GET)
	public String showProduct7(Model model) throws Exception
	{
		int num = 7;
		List<ProductVO> products = productService.readProductList(num);
		model.addAttribute("products", products);
		return "product/product7";
	}
	
	@RequestMapping(value = {"/show8"}, method = RequestMethod.GET)
	public String showProduct8(Model model) throws Exception
	{
		int num = 8;
		List<ProductVO> products = productService.readProductList(num);
		model.addAttribute("products", products);
		return "product/product8";
	}
	
	@RequestMapping(value = {"/show9"}, method = RequestMethod.GET)
	public String showProduct9(Model model) throws Exception
	{
		int num = 9;
		List<ProductVO> products = productService.readProductList(num);
		model.addAttribute("products", products);
		return "product/product9";
	}
}
