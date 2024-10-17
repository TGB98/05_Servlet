package edu.kh.todolist.controller;

import java.io.IOException;

import edu.kh.todolist.model.dto.Todo;
import edu.kh.todolist.model.service.TodoListService;
import edu.kh.todolist.model.service.TodoListServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

// Controller(요청을 받아 알맞은 서비스 호출, 응답을 어떻게 처리할 지 결정 -> View)

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
			TodoListService service = new TodoListServiceImpl();
			Todo todo = service.todoDetailView(index);
			
			// index 번째 todo가 없으면 null
			// 					 있으면 Todo 객체가 있음.
			
			// index 번째 todo가 존재하지 않을 경우
			// -> 메인 페이지(/) redirect
			//    "해당 index에 todo 가 존재하지 않습니다."
			// 	  alert 출력.
			if(todo == null) {
				
				// message -> session에 세팅
				HttpSession session = req.getSession();
				session.setAttribute("message", "해당 index에 todo 가 존재하지 않습니다.");
				
				resp.sendRedirect("/");
				return;
			}
			
			// 3. index 번째 Todo 객체가 존재하는 경우 detail.jsp 로 forward 해서 응답
			// -> detail.jsp (request scope 세팅된 todo 객체를 출력해주는 일)
			
			// 요청 위임한 페이지에서
			// 서비스로부터 얻어온 todo를 사용하기 위해 request scope 세팅.
			req.setAttribute("todo", todo);
			
			if(todo != null) {
				
				String path = "/WEB-INF/views/detail.jsp";
				
				RequestDispatcher dispatcher = req.getRequestDispatcher(path);
				
				dispatcher.forward(req, resp);

			}

			
		} catch(Exception e) {
			e.printStackTrace();
		}
		

		
	}
	
}
