package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.neuedu.dao.ProductDao;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.utils.DBUtils;

public class ProductDaoImpl implements ProductDao {

	@Override
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			
			String  sql="insert into product(name,pdesc,price) values (?,?,?)";
			st=conn.prepareStatement(sql);
			//占位符赋值
			st.setString(1, product.getName());
			st.setString(2, product.getDesc());
			st.setDouble(3, product.getPrice());
//			st.setString(4, product.getRule());
//			st.setString(5, product.getImage());
//			st.setInt(6, product.getStock());
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
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		List<Product> products=new ArrayList<Product>();
		
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			
			String  sql="select id,name,pdesc,price,rule ,image,stock from  product";
			st=conn.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
			 int  id= rs.getInt("id");	
			 String  name=rs.getString("name");
			 String pdesc=rs.getString("pdesc");
			 double price=rs.getDouble("price");
			 String rule=rs.getString("rule");
			 String  image=rs.getString("image");
			 int  stock=rs.getInt("stock");	
			 Product product=new Product(id,name,pdesc,price,rule,image,stock);
			 products.add(product); 
			}
			
			return products;
			
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
	public List<Product> findAllorder() {
		// TODO Auto-generated method stub
	List<Product> products=new ArrayList<Product>();
		
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			
			String  sql="select name,pdesc,price from  product ORDER BY price";
			st=conn.prepareStatement(sql);
			System.out.println(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
			 String  name=rs.getString("name");
			 String pdesc=rs.getString("pdesc");
			 double price=rs.getDouble("price");
			 Product product=new Product(name,pdesc,price);
			 products.add(product); 
			}
			
			return products;
			
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
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		//1.连接数据库
		//5.执行sql语句
		int count=0;
		try {
			Connection conn =DBUtils.getConnection();
			//2.准备sql语句
			String sql ="update product set name=?,price=?,image=?,rule=?,stock=?,pdesc=? where id=? ";
			//3.预编译sql语句
			PreparedStatement p =conn.prepareStatement(sql);
			//4.赋值
			p.setString(1,product.getName());
			p.setDouble(2, product.getPrice());
			p.setString(3,product.getImage());
			p.setString(4,product.getRule());
			p.setInt(5,product.getStock());
			p.setString(6,product.getDesc());
			p.setInt(7,product.getId());
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
//删除数据
	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		//删除数据
		int count=0;
		try {
			Connection conn = DBUtils.getConnection();
			String sql = "delete from product where id=?";
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
	public Product findById(int id) {
		// TODO Auto-generated method stub
		
		// TODO Auto-generated method stub
				Product product=new Product();
				
				Connection conn=null;
				PreparedStatement st=null;
				try {
					conn=DBUtils.getConnection();
					
					String  sql="select id,name,pdesc,price,rule ,image,stock from  product where id=?";
					st=conn.prepareStatement(sql);
					st.setInt(1, id);
					System.out.println(sql);
					ResultSet rs=st.executeQuery();
					
					if(rs.first()) {
						 int  _id= rs.getInt("id");	
						 String  name=rs.getString("name");
						 String pdesc=rs.getString("pdesc");
						 double price=rs.getDouble("price");
						 String rule=rs.getString("rule");
						 String  image=rs.getString("image"); 
						 int stock=rs.getInt("stock");
						 product.setId(_id);
                         product.setName(name);
                         product.setPrice(price);
                         product.setDesc(pdesc);
                         product.setRule(rule);
                         product.setImage(image);
                         product.setStock(stock);
					}
					
					
					
					return product;
					
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
				
		return product;
	}

	@SuppressWarnings("resource")
	@Override
	public PageModel<Product> findProductByPage(int pageNo, int pageSize) {
		PageModel<Product> pageModel=new PageModel<Product>();
		
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnection();
			//总记录数
			String sqlcount="select count(id) from product";
			st=conn.prepareStatement(sqlcount);
			rs=st.executeQuery();
			if(rs.next()) {
				int totalcount=rs.getInt(1);//总记录
				//计算多少页
				int totalPage=((totalcount%pageSize)==0)?totalcount/pageSize:(totalcount/pageSize)+1;
				pageModel.setTotalPage(totalPage);
			}
			//?偏移量?多少条
			String  sql="select id,name,pdesc,price,rule ,image,stock from  product limit ?,?";
			st=conn.prepareStatement(sql);
			st.setInt(1, (pageNo-1)*pageSize);
			st.setInt(2, pageSize);
			System.out.println(sql);
		    rs=st.executeQuery();
			List<Product> list=new ArrayList<Product>();
			while(rs.next()) {
			 int  id= rs.getInt("id");	
			 String  name=rs.getString("name");
			 String pdesc=rs.getString("pdesc");
			 double price=rs.getDouble("price");
			 String rule=rs.getString("rule");
			 String  image=rs.getString("image");
			 int  stock=rs.getInt("stock");
			
			 Product product=new Product(id,name,pdesc,price,rule,image,stock);
			 list.add(product); 
				pageModel.setData(list);
			}
			pageModel.setCurrentPage(pageNo);
			
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
		
		
		return pageModel;
	}

	@Override
	public List<Product> findBycategory_id(int category_id) {
          List<Product> products=new ArrayList<Product>();
		
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			
			String  sql="select id,name,pdesc,price,rule ,image,stock from  product where category_id=?";
			st=conn.prepareStatement(sql);
			st.setInt(1,category_id);
			System.out.println(sql);
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
			 int  id= rs.getInt("id");	
			 String  name=rs.getString("name");
			 String pdesc=rs.getString("pdesc");
			 double price=rs.getDouble("price");
			 String rule=rs.getString("rule");
			 String  image=rs.getString("image");
			 int  stock=rs.getInt("stock");	
			 Product product=new Product(id,name,pdesc,price,rule,image,stock);
			 products.add(product); 
			}
			
			return products;
			
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
	public boolean updateStock(Product product) {
	
		// TODO Auto-generated method stub
		//1.连接数据库
		//5.执行sql语句
		int count=0;
		try {
			Connection conn =DBUtils.getConnection();
			//2.准备sql语句
			String sql ="update product set stock=? where id=? ";
			//3.预编译sql语句
			PreparedStatement p =conn.prepareStatement(sql);
			//4.赋值
			p.setInt(1, product.getStock());
			p.setInt(1, product.getId());
			System.out.println(sql);
			count=p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(count!=0) {
			return true;
		}
		return false;
		
	}
	public static void main(String[] args) {
		ProductDaoImpl a=new ProductDaoImpl();
         List<Product> users = a.findAllorder();
           String info=JSONArray.toJSONString(users);
            System.out.println(info);

    }

	

}
