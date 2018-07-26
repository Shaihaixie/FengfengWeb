package com.neuedu.dao;

import java.util.List;

import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;

public interface CategoryDao {

	 /**
	  * ������
	  * */
	boolean  addCategory(Category category);
	/**
	 * �鿴��Ʒ���
	 * */
	List<Category> findAll();
	/**
	 * �޸���Ʒ���
	 * */
	boolean  updateCategory(Category category);
	/**
	 * ɾ����Ʒ���
	 * */
	boolean  deleteCategory(int id);
	
	/**�������id��ѯ��Ʒ*/
	Category  findById(int id);
	
	/**��ҳ��ȡ
	 * pageNo��ҳ
	 * pageSizeҳ������
	 * */
	public  PageModel<Category> findCategoryByPage(int pageNo, int pageSize);
	
	List<Category> findAllparentname();
	/**���ݸ����Ҷ�������*/
	List<Category> findAllsonname(String parentname);
	
}
