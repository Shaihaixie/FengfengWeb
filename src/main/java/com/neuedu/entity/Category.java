package com.neuedu.entity;

import java.sql.Date;

public class Category {
 private int id;//商品类别id
 private  int parent_id;//商品父类别id
 private  String cname;//商品类别名字
 private int status;//商品状态，默认1，停用是2
 private int sort_order;//排序方式
 private String create_time;
 private String update_time;
 private  Product  product;

public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getParent_id() {
	return parent_id;
}
public void setParent_id(int parent_id) {
	this.parent_id = parent_id;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public int getSort_order() {
	return sort_order;
}
public void setSort_order(int sort_order) {
	this.sort_order = sort_order;
}
public String getCreate_time() {
	return create_time;
}
public void setCreate_time(String create_time) {
	this.create_time = create_time;
}
public String getUpdate_time() {
	return update_time;
}
public void setUpdate_time(String update_time) {
	this.update_time = update_time;
}
public Category(int id, int parent_id, String cname, int status, int sort_order, String create_time, String update_time) {
	super();
	this.id = id;
	this.parent_id = parent_id;
	this.cname = cname;
	this.status = status;
	this.sort_order = sort_order;
	this.create_time = create_time;
	this.update_time = update_time;
}
public Category() {
	super();
}
}
