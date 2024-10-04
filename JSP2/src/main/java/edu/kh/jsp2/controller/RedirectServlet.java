package edu.kh.jsp2.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/fr/redirect")
public class RedirectServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// requestScope 에 속성 추가하기.
		req.setAttribute("str2", "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		
		// session scope 에 속성 추가하기.
		HttpSession session = req.getSession();
		session.setAttribute("sessionNum", 10000);
		
		
		// redirect - Get 요청 (재요청)
		// resp.sendRedirect("다시 요청할 Servlet 주소");
		// -> 파일 경로가 아닌
		//    다시 요청할 Servlet의 @WebServlet()에 작성된 주소 작성 해야함.
		resp.sendRedirect("/fr/result");
		
		
		
		
	}
	
}
