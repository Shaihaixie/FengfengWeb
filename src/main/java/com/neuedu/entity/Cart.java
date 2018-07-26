package com.neuedu.entity;

import java.io.Serializable;

/**
 * 购物车实体类
 * */
public class Cart  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5117733379863943502L;
	private  int id;
	private  int productid;
	private  Product  product;
	private  double total;
	private  int  productNum;//商品数量
	public Cart(int id, Product product, int productNum,int productid,double total) {
		super();
		this.id = id;
		this.product = product;
		this.productNum = productNum;
		this.productid=productid;
		this.total=total;
	}
	public Cart() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getProductNum() {
		return productNum;
	}
	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	@Override
	public String toString() {
		return "Cart [id=" + id + ", product=" + product + ", productNum=" + productNum + "]";
	}
	
	
	
	
	
	
}
