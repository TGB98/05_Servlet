package edu.kh.jsp2.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.kh.jsp2.dto.Book;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/book/list")
public class BookServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// 요청 처리
		// Book 으로 타입이 제한된 List 생성.
		List<Book> bookList = new ArrayList<Book>();
		
		// bookList에 데이터 추가
		bookList.add(new Book("호이로 마법 쓰는 법", "둘리", 10000));
		bookList.add(new Book("소드마스터가 되는 법", "소드마스터 고길동", 20000));
		bookList.add(new Book("루테란", "실리안", 15000));
		bookList.add(new Book("JSP", "서블릿", 20000));
		bookList.add(new Book("OH", "예스", 5000));
		bookList.add(new Book("초코", "파이", 8000));
		bookList.add(new Book("로스트", "아크", 12000));
		
		//bookList를 요청 위임된 JSP에서도 유지되어 사용될 수 있도록 request scope 객체에 속성 추가
		req.setAttribute("bookList", bookList);
		
		// 응답 처리
		// JSP로 요청 위임
		
		String path = "/WEB-INF/views/book/bookList.jsp";
		
		RequestDispatcher dispatcher = req.getRequestDispatcher(path);
		
		dispatcher.forward(req, resp);
		
	}
	
	
}
