package org.kpu.myweb.service;

import java.util.List;

import org.kpu.myweb.domain.BasketVO;
import org.kpu.myweb.domain.ProductVO;

public interface ProductService 
{
	public List<ProductVO> readProductList(int num) throws Exception;
	//public List<BasketVO> readBasketList() throws Exception;
	public void updateProduct(BasketVO bvo) throws Exception;
}
