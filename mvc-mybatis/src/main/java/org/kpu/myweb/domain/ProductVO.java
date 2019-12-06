package org.kpu.myweb.domain;

public class ProductVO 
{
	private int num; //상품번호
	private String name; //상품이름
	private int price; //상품가격
	private int product; //상품개수
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getProduct() {
		return product;
	}
	public void setProduct(int pProduct) {
		this.product = pProduct;
	}

}

// 상품번호, 상품이름, 상품가격, 남은 상품 개수
