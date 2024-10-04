package edu.kh.todolist.model.service;

import edu.kh.todolist.model.dto.Todo;

public class TodoListReadServiceImpl implements TodoListReadService {


	@Override
	public int readService(int index) throws Exception {
		Todo todo = new Todo(int index);
		
		return 0;
	}

}
