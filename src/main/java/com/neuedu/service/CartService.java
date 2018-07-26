package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.Cart;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;

public interface CartService {

	/**
	 * ��ӹ��ﳵ
	 **/
	boolean  addCart(Cart cart);
	/**
	 * ɾ��
	 * */
	boolean  deleteCart(int id);
	/**
	 * �޸Ĺ��ﳵ
	 * */
	boolean  updataeCart(Cart cart);
	/**
	 * ��ѯ���ﳵ
	 * */
	List<Cart> findAllCart();
	  public  Cart  findCartById(int id);
	  Cart findcartByproductid(int productid);
	/**
	 * ��ȡ���ﳵ����Ʒ����
	 * */
	int  getCartNum();
	/**�޸Ĺ��ﳵ��Ʒ����
	 * @param  id  Ҫ�޸ĵĹ��ﳵ��Id
	 * @param  num �޸ĺ������
	 * */
	boolean  updateCart(int id, int num);
	 /**��ҳ��ȡ*/
    public PageModel<Cart> findCartByPage(int pageNo, int pageSize);
	
}
