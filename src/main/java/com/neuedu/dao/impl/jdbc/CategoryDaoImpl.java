package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.CategoryDao;
import com.neuedu.dao.ProductDao;
import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.utils.DBUtils;

public class CategoryDaoImpl implements CategoryDao {
	ProductDao productDao=new ProductDaoImpl();
	@Override
	public boolean addCategory(Category category) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			
			String  sql="insert into category(id,cname,status,sort_order,create_time,update_time) values (?,?,?,?,?,?)";
			st=conn.prepareStatement(sql);
			//占位符赋值
			st.setInt(1, category.getId());
			st.setString(2, category.getCname());
			st.setInt(3, category.getStatus());
			st.setInt(4, category.getSort_order());
			st.setString(5, category.getCreate_time());
			st.setString(6, category.getUpdate_time());
			System.out.println(sql);
			st.execute();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return false;
	}

	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
       List<Category> categorys=new ArrayList<Category>();
		
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			String  sql="SELECT  id,parent_id,cname,status,sort_order,create_time,update_time FROM category ";
			st=conn.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
			 int  id= rs.getInt("id");
			 int  parent_id=rs.getInt("parent_id");
			 String  cname=rs.getString("cname");
			 int  status=rs.getInt("status");
			 int  sort_order=rs.getInt("sort_order");
			 String create_time=rs.getString("create_time");
			 String update_time=rs.getString("update_time");
			 Category category=new Category();
			 Category category1=new Category(id,parent_id,cname,status,sort_order,create_time,update_time);
			 category1.setProduct(productDao.findById(id));
			 categorys.add(category1); 
			}
			
			return categorys;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		int count=0;
		try {
			Connection conn =DBUtils.getConnection();
			//2.准备sql语句
			String sql ="update category set parent_id=?,cname=?,status=?,sort_order=?,create_time=?,update_time=? where id=?";
			//3.预编译sql语句
			PreparedStatement p =conn.prepareStatement(sql);
			//4.赋值
			p.setInt(1, category.getParent_id());
			p.setString(2, category.getCname());
			p.setInt(3, category.getStatus());
			p.setInt(4, category.getSort_order());
			p.setString(5, category.getCreate_time());
			p.setString(6, category.getUpdate_time());
			p.setInt(7, category.getId());
			System.out.println(sql);
			count = p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count!=0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteCategory(int id) {
		// TODO Auto-generated method stub
		int count=0;
		try {
			Connection conn = DBUtils.getConnection();
			String sql = "delete from category where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			System.out.println(sql);
			//创建preparement
			count = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count!=0) {
			return true;
		}
		return false;
	}

	@Override
	public Category findById(int id) {
		// TODO Auto-generated method stub
		
		Category  category=new Category();
		
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			
			String  sql="SELECT  id,parent_id,cname,status,sort_order,create_time,update_time FROM category WHERE id=?";
			st=conn.prepareStatement(sql);
			st.setInt(1, id);
			System.out.println(sql);
			ResultSet rs=st.executeQuery();
			if(rs.first()) {
				int _id=rs.getInt("id");
				int parent_id=rs.getInt("parent_id");
				String  cname=rs.getString("cname");
				int status=rs.getInt("status");
				int sort_order=rs.getInt("sort_order");
				String create_time=rs.getString("create_time");
				String update_time=rs.getString("update_time");
				category.setId(_id);
				category.setParent_id(parent_id);
				 category.setCname(cname);
				 category.setStatus(status);
				 category.setSort_order(sort_order);
				 category.setCreate_time(create_time);
				 category.setUpdate_time(update_time);
			}
			
	
			return category;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
return category;
	}

	@SuppressWarnings("resource")
	@Override
	public PageModel<Category> findCategoryByPage(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
      PageModel<Category> category=new PageModel<Category>();
		
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnection();
			
			String  sql="SELECT  id,parent_id,cname,status,sort_order,create_time,update_time FROM category limit ?,?";
			st=conn.prepareStatement(sql);
			st.setInt(1, (pageNo-1)*pageSize);
			st.setInt(2, pageSize);
			System.out.println(sql);
		    rs=st.executeQuery();
			List<Category> list=new ArrayList<Category>();	
				while(rs.next()) {
					 int  id= rs.getInt("id");
					 int  parent_id=rs.getInt("parent_id");
					 String  cname=rs.getString("cname");
					 int  status=rs.getInt("status");
					 int  sort_order=rs.getInt("sort_order");
					 String create_time=rs.getString("create_time");
					 String update_time=rs.getString("update_time");
					 Category categorya=new Category(id,parent_id,cname,status,sort_order,create_time,update_time);
					 categorya.setProduct(productDao.findById(id));
					 list.add(categorya); 
					 category.setData(list);
					}
				category.setCurrentPage(pageNo);
			//总记录数
			String sqlcount="select count(id) from category";
			st=conn.prepareStatement(sqlcount);
			rs=st.executeQuery();
			if(rs.next()) {
				int totalcount=rs.getInt(1);//总记录
				//计算多少页
				int totalPage=((totalcount%pageSize)==0)?totalcount/pageSize:(totalcount/pageSize)+1;
				category.setTotalPage(totalPage);
			}
			//?偏移量?多少条	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return category;
	}

	@Override
	public List<Category> findAllparentname() {
		// TODO Auto-generated method stub
List<Category> categorys=new ArrayList<Category>();
		
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			String  sql="  select  cname  FROM category WHERE parent_id=0 ";
			st=conn.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
			 String  cname=rs.getString("cname");
			 Category category=new Category();
			 category.setCname(cname);
			 categorys.add(category); 
			}
			
			return categorys;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;

	}

	@Override
	public List<Category> findAllsonname(String parentname) {
		// TODO Auto-generated method stub
List<Category> categorys=new ArrayList<Category>();
		
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			String  sql="select  id,cname FROM  category  WHERE  parent_id=(SELECT id FROM category where cname=?) ";
			st=conn.prepareStatement(sql);
			st.setString(1, parentname);
			System.out.println(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				int id=rs.getInt("id");
			 String  cname=rs.getString("cname");
			 Category category=new Category();
			 category.setId(id);
			 category.setCname(cname);
			 categorys.add(category); 
			}
			
			return categorys;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				DBUtils.close(conn, st);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;

	}
}
