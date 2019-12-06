package org.kpu.myweb.service;

import java.util.List;

import org.kpu.myweb.domain.BasketVO;
import org.kpu.myweb.domain.ProductVO;
import org.kpu.myweb.persistence.ProductDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService
{
	@Autowired
	private ProductDAO productDAO;
	
	public List<ProductVO> readProductList(int num) throws Exception
	{
		return productDAO.readList(num);
	}
	
	/*public List<BasketVO> readBasketList() throws Exception
	{
		return productDAO.readbasketList();
	}*/
	
	
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.READ_COMMITTED, timeout=10)
	public void updateProduct(BasketVO bvo) throws Exception
	{
		productDAO.insert(bvo);
		productDAO.update(bvo);
	}
}
