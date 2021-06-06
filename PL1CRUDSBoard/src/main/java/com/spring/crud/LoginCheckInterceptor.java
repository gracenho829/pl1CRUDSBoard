package com.spring.crud;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.ModelAndView;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter{

		@Override
		public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
			HttpSession session = request.getSession();
			Object obj = session.getAttribute("login");
			if (obj == null) {
				response.sendRedirect(request.getContextPath() + "/login/login");
				return false;
			}
			return true;
		}
}
