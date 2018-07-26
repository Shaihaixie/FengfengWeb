package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;

public interface ProductDao {

	 /**
	  * �����Ʒ
	  * */
	boolean  addProduct(Product product);
	/**
	 * �鿴��Ʒ
	 * */
	List<Product> findAll();
	List<Product> findAllorder();
	/**
	 * �޸���Ʒ
	 * */
	boolean  updateProduct(Product product);
	/**
	 * ɾ����Ʒ
	 * */
	boolean  deleteProduct(int id);
	
	/**����id��ѯ��Ʒ*/
	Product  findById(int id);
	/**����category_id����Ʒ
	 * */
	List<Product> findBycategory_id(int category_id);
	/**��ҳ��ȡ
	 * pageNo��ҳ
	 * pageSizeҳ������
	 * */
	public  PageModel<Product> findProductByPage(int pageNo, int pageSize);
	
	public boolean updateStock(Product product) ;
	
	
}
