package com.neuedu.entity;

import java.io.Serializable;

/**
 * java实体类 javaBean
 * 定义JavaBean
 * (1)属性私有
 * (2)提供有参/无参的构造方法
 * （3）提供get/set方法
 * （4）实现序列化接口
 * */
public class Product implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6185202905228190806L;
	private  int  id; //商品id
	private  String  name;//商品名称
	private  String  desc;//商品描述
	private  double  price;//商品价格
	private  String  rule;//商品规格
	private String  image;
	private int  category_id;//商品类别id
	
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	private  int  stock;//库存
	
	
	public Product() {
		super();
	}
	public Product(int id ,String name) {
		this.id=id;
		this.name=name;
	}
	public Product( String name, String desc, double price, String rule) {
		super();
		
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.rule = rule;
	}
	public Product( String name, String desc, double price) {
		super();
		
		this.name = name;
		this.desc = desc;
		this.price = price;
	
	}
	public Product(int id, String name, String desc, double price, String rule, String image, int stock) {
		super();
		this.id=id;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.rule = rule;
		this.stock=stock;
		this.image=image;
	}
	public Product(int id, String name, String desc, double price, String rule) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.rule = rule;
	}
	
	public Product(int id, String name, String desc, double price, String rule, String image) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.price = price;
		this.rule = rule;
		this.image = image;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getRule() {
		return rule;
	}
	public void setRule(String rule) {
		this.rule = rule;
	}
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	
	
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", desc=" + desc + ", price=" + price + ", rule=" + rule + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
