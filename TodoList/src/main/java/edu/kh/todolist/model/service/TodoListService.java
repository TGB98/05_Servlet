package edu.kh.todolist.model.service;

import java.util.List;

import edu.kh.todolist.model.dto.Todo;

public interface TodoListService {

	/**
	 * 할 일 목록 반환 서비스
	 * @return todoList
	 */
	List<Todo> todoListFullView(); // public abstract 를 명시 하지 않아도 public abstract 로 인식함.

	/**
	 * 전달 받은 title, detail 이용해 할 일 추가 서비스
	 * @param title
	 * @param detail
	 * @return 추가된 index 번호 or 추가 실패 시 -1 반환.
	 * @throws Exception 
	 */
	int todoAdd(String title, String detail) throws Exception;

	
	
	
	
}
