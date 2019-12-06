package org.kpu.myweb.domain;

public class CartVO 
{
	private int cartid;
	private int pnum;
	private String pname;
	private int pprice;
	private int count;
	private String cid;
	public int getCartid()
	{
		return cartid;
	}
	public void setCartid(int cartid)
	{
		this.cartid = cartid;
	}
	public int getPnum() {
		return pnum;
	}
	public void setPnum(int pnum) {
		this.pnum = pnum;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public int getPprice() {
		return pprice;
	}
	public void setPprice(int pprice) {
		this.pprice = pprice;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
}
