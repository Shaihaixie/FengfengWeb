package com.neuedu.service;
import java.util.List;
import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;

public interface CategoryService {

	/**������*/
    public  boolean addCategory(Category category);	
    /**��ѯ���*/
    public  List<Category> findAll();
    /**�޸���Ʒ���*/
    public  boolean updateCategory(Category category);
    /**ɾ����Ʒ���*/
    public  boolean deleteCategory(int id);
    /**����id��ѯ��Ʒ���*/
    public  Category  findById(int id);
    /**��ҳ��ȡ*/
    public PageModel<Category> findCategoryByPage(int pageNo, int pageSize);
    /**������*/
    public  List<Category>  findAllparentname();
    /**������*/
    public  List<Category>  findAllsonname(String sonname);
   
}
