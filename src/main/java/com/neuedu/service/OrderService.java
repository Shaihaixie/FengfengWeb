package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Cart;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.UserOrder;

public interface OrderService {

	/**
	 * 用户下单
	 * */
	boolean  createOrder(UserOrder userOrder);
	 List<UserOrder> findAllorder();
	/**
	 * 
	 * 生成订单编号order_no
	 * */
  long  generateOrderNo();
  /**分页获取*/
  public PageModel<UserOrder> findOrderByPage(int pageNo, int pageSize);
}
