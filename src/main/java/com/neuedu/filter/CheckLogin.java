package com.neuedu.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neuedu.entity.Account;
import com.neuedu.service.ILoginService;
import com.neuedu.service.impl.LoginServiceImpl;

/**
 * Servlet Filter implementation class CheckLogin
 */
@WebFilter("/view/*")
public class CheckLogin implements Filter {

    /**
     * Default constructor. 
     */
    public CheckLogin() {
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
		HttpServletRequest _request=(HttpServletRequest)request;
		HttpServletResponse _response=(HttpServletResponse)response;
			  HttpSession session=_request.getSession();
				Object  o=session.getAttribute("token");
				Object accb=session.getAttribute("acc");
				if(o!=null&&accb!=null) {
					String token=(String)o;
					ILoginService loginService=new LoginServiceImpl();
					Account acc=(Account)accb;
				  String  result_token=	loginService.findTokenByAccountid(acc.getAccountId());
				if(result_token!=null) {
					 if(token.equals(result_token)) {
							chain.doFilter(request, response);
							return;
						}
				    }
			   
		}
	_response.sendRedirect("http://localhost:8080/FengSHOP/login.jsp");
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
