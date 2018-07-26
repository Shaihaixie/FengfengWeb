package com.neuedu.service.impl;

import java.util.List;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.impl.jdbc.CartDaoImpl;
import com.neuedu.entity.Cart;
import com.neuedu.entity.PageModel;
import com.neuedu.service.CartService;

public class CartServiceImpl implements CartService {

	CartDao cartDao=new CartDaoImpl();
	
	@Override
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.addCart(cart);
	}

	@Override
	public boolean deleteCart(int id) {
		// TODO Auto-generated method stub
		return cartDao.deleteCart(id);
	}

	@Override
	public boolean updataeCart(Cart cart) {
		// TODO Auto-generated method stub
		return cartDao.updataeCart(cart);
	}

	@Override
	public List<Cart> findAllCart() {
		// TODO Auto-generated method stub
		return cartDao.findAllCart();
	}

	@Override
	public int getCartNum() {
		// TODO Auto-generated method stub
		return cartDao.getCartNum();
	}

	@Override
	public boolean updateCart(int id, int num) {
		// TODO Auto-generated method stub
		return cartDao.updateCart(id, num);
	}

	@Override
	public Cart findCartById(int id) {
		// TODO Auto-generated method stub
		return cartDao.findcartById(id);
	}

	@Override
	public PageModel<Cart> findCartByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return cartDao.findCartByPage(pageNo, pageSize);
	}

	@Override
	public Cart findcartByproductid(int productid) {
		// TODO Auto-generated method stub
		return cartDao.findcartByproductid(productid);
	}

}
