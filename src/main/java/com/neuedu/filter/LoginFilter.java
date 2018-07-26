package com.neuedu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;
import com.neuedu.service.impl.LoginServiceImpl;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/login.jsp")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		System.out.println("到达过滤器");
		HttpServletRequest _request=(HttpServletRequest)request;
		HttpServletResponse _response=(HttpServletResponse)response;
		  Cookie[] cookies=  _request.getCookies();
		  String name=null;
		  String pas=null;
		  if(cookies!=null) {
			  for (Cookie c : cookies) {
				  if( c.getName().equals("name")) {
					  //用户名
					 name= c.getValue();
					 System.out.println("username==="+name);
				  } if( c.getName().equals("pas")) {
					  //密码
					  pas= c.getValue();
					 System.out.println("password==="+pas);
				  }
				 
			}
		  }
		  
		  if(name!=null&&pas!=null&&!name.equals("")&&!pas.equals("")) {
			ILoginService  loginService= new  LoginServiceImpl();
			  Account account=loginService.doLogin(name, pas);
			  if(account!=null) {
					request.getRequestDispatcher("home.jsp").forward(request, response);
			  }else {
				  chain.doFilter(request, response);
				}
		  }else {
			  chain.doFilter(request, response);
			}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
