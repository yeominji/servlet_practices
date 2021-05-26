package com.douzone.guestbook.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.douzone.guestbook.dao.GuestbookDao;
import com.douzone.guestbook.vo.GuestbookVo;


public class GuestbookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public GuestbookController() {
        super();
      
    }


	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
			
			String action = request.getParameter("a");
			
			if("form".equals(action)) {
				// view로 포워딩
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/deleteform.jsp");
				rd.forward(request, response);
			} else if("add".equals(action)) {
				//1. 요청처리

				
				String Name = request.getParameter("name");
				String Password = request.getParameter("password");
				String Message = request.getParameter("message");
				
			
				GuestbookVo vo = new GuestbookVo();
				vo.setName(Name);
				vo.setPassword(Password);
				vo.setMessage(Message);
				vo.setRegDate(LocalDateTime.now().toString());
				
			      new GuestbookDao().insert(vo);
			
				response.sendRedirect(request.getContextPath() + "/gd");
			} else {
				
				
				
				List<GuestbookVo> list = new GuestbookDao ().findAll();
				
			
				request.setAttribute("list", list);
				
				
				RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
				rd.forward(request, response);
			}
		}
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			doGet(request, response);
		}
	
	}
