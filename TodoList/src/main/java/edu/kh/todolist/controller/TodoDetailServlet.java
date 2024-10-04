package edu.kh.todolist.controller;

import java.io.IOException;

import edu.kh.todolist.model.service.TodoListReadService;
import edu.kh.todolist.model.service.TodoListReadServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/todo/detail")
public class TodoDetailServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// ?index=0 or ?index=1 ...
		// req.getParameter("index") --> String 
		// 1. 전달받은 파라미터 Integer.parseInt 이용하여 정수형으로 변환.
		int index = Integer.parseInt(req.getParameter("index"));
		
		// 2. 상세 조회 서비스 호출 후 결과 반환 받기.
		// Todo 객체 반환 받기. -> 서비스 메서드 호출 시 index 전달
		try {
			TodoListReadService service = new TodoListReadServiceImpl();
			int listIndex = service.readService(index);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		// 3. index 번째 Todo 객체가 존재하는 경우 detail.jsp 로 forward 해서 응답
		// -> detail.jsp (request scope 세팅된 todo 객체를 출력해주는 일)
		String path = "/WEB-INF/views/detail.jsp";
		
	
		
	}
	
}
