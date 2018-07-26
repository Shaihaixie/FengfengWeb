package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.neuedu.dao.CartDao;
import com.neuedu.dao.ProductDao;
import com.neuedu.entity.Cart;
import com.neuedu.entity.Category;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.Product;
import com.neuedu.utils.DBUtils;

public class CartDaoImpl implements CartDao {

	ProductDao productDao=new ProductDaoImpl();
	@Override
	public boolean addCart(Cart cart) {
		// TODO Auto-generated method stub	
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();			
			String  sql="insert into cart(productid,productnum) values (?,?)";
		  	st=conn.prepareStatement(sql);
		  	st.setInt(1, cart.getProductid());
			st.setInt(2, cart.getProductNum());
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
	public boolean deleteCart(int id) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			String  sql="delete from cart where id=?";
			   st=conn.prepareStatement(sql);
			   st.setInt(1, id);
			System.out.println(sql);
			st.executeUpdate();
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
	public boolean updataeCart(Cart cart) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			String  sql="update cart set productnum=? where id=?";
			st=conn.prepareStatement(sql);
			st.setInt(1, cart.getProductNum());
			st.setInt(2, cart.getId());
			System.out.println(sql);
			st.executeUpdate();
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
	public List<Cart> findAllCart() {
		// TODO Auto-generated method stub
		
	List<Cart> carts=new ArrayList<Cart>();
		
		Connection conn=null;
		Statement st=null;
		try {
			conn=DBUtils.getConnection();
			st=conn.createStatement();
			String  sql="select id,productid,productnum from  cart";
			System.out.println(sql);
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()) {
			 int  id= rs.getInt("id");	
			 int  productid=rs.getInt("productid");
			 int num=rs.getInt("productnum");	 
			 double total=productDao.findById(productid).getPrice()*num;
			 Cart cart=new Cart();
			 cart.setId(id);
			 cart.setProductid(productid);
			 cart.setProductNum(num);
			 cart.setProduct(productDao.findById(productid));
			 cart.setTotal(total);
			 carts.add(cart); 	
			}
			return carts;
			
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
	public int getCartNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean updateCart(int id, int num) {
		// TODO Auto-generated method stub
		Connection conn=null;
		Statement st=null;
		try {
			conn=DBUtils.getConnection();
			String  sql="update cart set productnum=?where id=?";
			st=conn.prepareStatement(sql);
			System.out.println(sql);
			
			st.execute(sql);
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
	public void clearCart() {
		// TODO Auto-generated method stub

	}

	@Override
	public Cart findcartById(int id) {
		// TODO Auto-generated method stub
		Cart cart=new Cart();
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			String  sql="select id,productid,productnum from  cart where id=?";
			st=conn.prepareStatement(sql);
			st.setInt(1, id);
			System.out.println(sql);
			ResultSet rs=st.executeQuery();
			if(rs.first()) {
				 int  _id= rs.getInt("id");	
				 int  productid=rs.getInt("productid");
				 int productnum=rs.getInt("productnum");
				 cart.setId(_id);
				 cart.setProductid(productid);
				 cart.setProductNum(productnum);
				 cart.setProduct(productDao.findById(productid));
			}	
			return cart;
			
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
		
return cart;
	}
	@Override
	public Cart findcartByproductid(int productid) {
		// TODO Auto-generated method stub
		Cart cart=new Cart();
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			String  sql="select id,productid,productnum from  cart where productid=?";
			st=conn.prepareStatement(sql);
			st.setInt(1, productid);
			System.out.println(sql);
			ResultSet rs=st.executeQuery();
			if(rs.first()) {
				 int  _id= rs.getInt("id");	
				 int  _productid=rs.getInt("productid");
				 int productnum=rs.getInt("productnum");
				 cart.setId(_id);
				 cart.setProductid(_productid);
				 cart.setProductNum(productnum);
			}
			
			
			
			return cart;
			
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
		
return cart;
	}

	@Override
	public PageModel<Cart> findCartByPage(int pageNo, int pageSize) {
		 PageModel<Cart> cart=new PageModel<Cart>();
			
			Connection conn=null;
			PreparedStatement st=null;
			ResultSet rs=null;
			try {
				conn=DBUtils.getConnection();
				
				String  sql="select id,productid,productnum from  cart limit ?,?";
				st=conn.prepareStatement(sql);
				st.setInt(1, (pageNo-1)*pageSize);
				st.setInt(2, pageSize);
				System.out.println(sql);
			    rs=st.executeQuery();
				List<Cart> list=new ArrayList<Cart>();	
					while(rs.next()) {
						 int  id= rs.getInt("id");	
						 int  productid=rs.getInt("productid");
						 int num=rs.getInt("productnum");	 
						 double total=productDao.findById(productid).getPrice()*num;
						 Cart carta=new Cart();
						 carta.setId(id);
						 carta.setProductid(productid);
						 carta.setProductNum(num);
						 carta.setProduct(productDao.findById(productid));
						 carta.setTotal(total);	
						 list.add(carta); 
						 cart.setData(list);
						}
					cart.setCurrentPage(pageNo);
				//总记录数
				String sqlcount="select count(id) from cart";
				st=conn.prepareStatement(sqlcount);
				rs=st.executeQuery();
				if(rs.next()) {
					int totalcount=rs.getInt(1);//总记录
					//计算多少页
					int totalPage=((totalcount%pageSize)==0)?totalcount/pageSize:(totalcount/pageSize)+1;
					cart.setTotalPage(totalPage);
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
			
			
			return cart;
		}
	public static void main(String[] args) {
		CartDaoImpl a=new CartDaoImpl();
		 PageModel<Cart> cart=new PageModel<Cart>();
		 List<Cart> carts= a.findAllCart();
           String info=JSONArray.toJSONString(carts);
            System.out.println(info);

    }	
		
}
