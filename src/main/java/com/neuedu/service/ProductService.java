package com.neuedu.service;

import java.util.List;

import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;

public interface ProductService {

	/**�����Ʒ*/
    public  boolean addProduct(Product product);	
    /**��ѯ��Ʒ*/
    public  List<Product> findAll();
    public  List<Product> findAllorder();
    /**�޸���Ʒ*/
    public  boolean  updateProduct(Product product);
    /**ɾ����Ʒ*/
    public  boolean deleteProduct(int id);
    /**����id��ѯ��Ʒ��Ϣ*/
    public  Product  findProductById(int id);
    /**����categoryid��ѯ��Ʒ��Ϣ*/
    public      List<Product> findBycategory_id(int category_id);
    /**��ҳ��ȡ*/
    public PageModel<Product> findProductByPage(int pageNo, int pageSize);
    
    public boolean updateStock(Product product);
}
