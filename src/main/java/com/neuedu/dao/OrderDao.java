package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Cart;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.UserOrder;

public interface OrderDao {
	/**��ҳ��ȡ
	 * pageNo��ҳ
	 * pageSizeҳ������
	 * */
	public  PageModel<UserOrder> findUserOrderByPage(int pageNo, int pageSize);
	/**
	 * ��������
	 * */
	
   boolean  createOrder(UserOrder userOrder);
   
   /**
    * ���ɶ���id
    * */
   int  generateOrderId();
   /**
    * �������ж���
    * */
    List<UserOrder> findAllorder();
	
}
