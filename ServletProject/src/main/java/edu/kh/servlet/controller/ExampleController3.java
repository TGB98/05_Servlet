package edu.kh.servlet.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/coffee")
public class ExampleController3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String orderer = req.getParameter("orderer");
		String coffee = req.getParameter("coffee");
		String type = req.getParameter("type");
		
		/*
		 * name 속성 값이 같은 파라미터가 여러 개인 경우
		 * String[] 로 한 번에 반환하는 getParameterValues("name 속성값") 사용.
		 * 
		 * */
		String[] optionArr = req.getParameterValues("opt");
		
		System.out.println(orderer);
		System.out.println(coffee);
		System.out.println(type);
		System.out.println(optionArr); // 주소값
		try {
			for(String opt : optionArr) {
				System.out.println(opt);
			}
		} catch(NullPointerException e) {
			e.printStackTrace();
			System.out.println("선택한 옵션이 없음.");
		}
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/result2.jsp");
		
		dispatcher.forward(req, resp);
		
	}
	
}
