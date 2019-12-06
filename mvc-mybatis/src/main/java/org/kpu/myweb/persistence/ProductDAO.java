package org.kpu.myweb.persistence;

import java.util.List;

import org.kpu.myweb.domain.BasketVO;
import org.kpu.myweb.domain.ProductVO;

public interface ProductDAO 
{
	public List<ProductVO> readList(int num) throws Exception;
	public List<BasketVO> readbasketList() throws Exception;
	public void insert(BasketVO bvo) throws Exception;
	public void update(BasketVO bvo) throws Exception;
}
