package com.store.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.store.service.CategoryService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GlobalInterceptor implements HandlerInterceptor {
	@Autowired
	CategoryService categoryService;
	
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response,ModelAndView modelAndView) throws Exception
//	{
//		request.setAttribute("cates", modelAndView);
//		//HandlerInterceptor.super.postHandle(request, response, response, modelAndView);
//	}
}
