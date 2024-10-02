package edu.kh.jsp2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/jstl/test")
public class JSTLTestServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// c:forEach 연습을 위한 List 생성.
		List<String> nameList = new ArrayList<String>();
		
		nameList.add("짱구");
		nameList.add("철수");
		nameList.add("훈이");
		nameList.add("유리");
		nameList.add("맹구");
		nameList.add("흰둥이");
		nameList.add("액션가면");
		nameList.add("고길동");
		nameList.add("둘리");
		nameList.add("희동이");
		
		// request scope (현재 Servlet -> 위임 받은 JSP 까지 유지)
		// 객체에 속성으로 List 를 세팅.
		req.setAttribute("nameList", nameList);
		
		String path = "/WEB-INF/views/jstl/test.jsp";
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		dispatcher.forward(req, resp);
	}
	
	
}
