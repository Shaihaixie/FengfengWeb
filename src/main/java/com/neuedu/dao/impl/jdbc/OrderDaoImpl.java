package com.neuedu.dao.impl.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.neuedu.dao.CartDao;
import com.neuedu.dao.OrderDao;
import com.neuedu.dao.ProductDao;
import com.neuedu.entity.Cart;
import com.neuedu.entity.PageModel;
import com.neuedu.entity.UserOrder;
import com.neuedu.utils.DBUtils;

public class OrderDaoImpl implements OrderDao {
	ProductDao productDao=new ProductDaoImpl();
	   CartDao  cartDao=new CartDaoImpl();
	@Override
	public boolean createOrder(UserOrder userOrder) {
		// TODO Auto-generated method stub
		
		
		UserOrder userOrder1=new UserOrder();
		Connection conn=null;
		PreparedStatement st=null;
		try {
			conn=DBUtils.getConnection();
			String  sql="insert into userorder(order_no,user_id,shipping_id,payment,payment_type,postage,status,create_time)"+
					"values (?,?,?,?,?,?,?,now())";	
			st=conn.prepareStatement(sql);
			System.out.println(sql);
			st.setLong(1, System.currentTimeMillis());
			st.setInt(2, userOrder.getUser_id());
			st.setInt(3, userOrder.getShipping_id());
			st.setDouble(4, userOrder.getPayment());
			st.setInt(5, userOrder.getPayment_type());
			st.setInt(6, userOrder.getPostage());
			st.setInt(7, userOrder.getStatus());
			userOrder1.setProduct(productDao.findById(userOrder.getUser_id()));
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
	public int generateOrderId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UserOrder> findAllorder() {
		// TODO Auto-generated method stub
		
		List<UserOrder> orders=new ArrayList<UserOrder>();
			
			Connection conn=null;
			Statement st=null;
			try {
				conn=DBUtils.getConnection();
				st=conn.createStatement();
				String  sql="select id,order_no,user_id,shipping_id,payment,payment_type,postage,create_time,status from  userorder";
				System.out.println(sql);
				ResultSet rs=st.executeQuery(sql);
				while(rs.next()) {
				 int  id= rs.getInt("id");	
				  Long   order_no=rs.getLong("order_no");
				 int user_id=rs.getInt("user_id");
				 int shipping_id=rs.getInt("shipping_id");
				 double payment=rs.getDouble("payment");
				 int payment_type=rs.getInt("payment_type");
				 int postage=rs.getInt("postage");
				 int status=rs.getInt("status");
				 String  create_time=rs.getString("create_time");
				 UserOrder order=new UserOrder();
				 order.setId(id);
				 order.setOrder_no(order_no);
				 order.setUser_id(user_id);
				 order.setShipping_id(shipping_id);
				 order.setPayment(payment);
				 order.setPayment_type(payment_type);
				 order.setPostage(postage);
				 order.setStatus(status);
				 order.setCreate_time(create_time);
				 order.setProduct(productDao.findById(shipping_id));
				 orders.add(order); 	
				}
				return orders;
				
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
	public PageModel<UserOrder> findUserOrderByPage(int pageNo, int pageSize) {
		PageModel<UserOrder> userorder=new PageModel<UserOrder>();
		
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			conn=DBUtils.getConnection();
			
			String  sql="select id,order_no,user_id,shipping_id,payment,payment_type,postage,create_time,status from  userorder limit ?,?";
			st=conn.prepareStatement(sql);
			st.setInt(1, (pageNo-1)*pageSize);
			st.setInt(2, pageSize);
			System.out.println(sql);
		    rs=st.executeQuery();
			List<UserOrder> list=new ArrayList<UserOrder>();	
				while(rs.next()) {
					 int  id= rs.getInt("id");	
					  Long   order_no=rs.getLong("order_no");
					 int user_id=rs.getInt("user_id");
					 int shipping_id=rs.getInt("shipping_id");
					 double payment=rs.getDouble("payment");
					 int payment_type=rs.getInt("payment_type");
					 int postage=rs.getInt("postage");
					 int status=rs.getInt("status");
					 String  create_time=rs.getString("create_time");
					 UserOrder order=new UserOrder();
					 order.setId(id);
					 order.setOrder_no(order_no);
					 order.setUser_id(user_id);
					 order.setShipping_id(shipping_id);
					 order.setPayment(payment);
					 order.setPayment_type(payment_type);
					 order.setPostage(postage);
					 order.setStatus(status);
					 order.setCreate_time(create_time);
					 order.setProduct(productDao.findById(shipping_id));
					 list.add(order); 
					 userorder.setData(list);
					}
				userorder.setCurrentPage(pageNo);
			//总记录数
			String sqlcount="select count(id) from userorder";
			st=conn.prepareStatement(sqlcount);
			rs=st.executeQuery();
			if(rs.next()) {
				int totalcount=rs.getInt(1);//总记录
				//计算多少页
				int totalPage=((totalcount%pageSize)==0)?totalcount/pageSize:(totalcount/pageSize)+1;
				userorder.setTotalPage(totalPage);
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
		
		
		return userorder;
	}

	

}
