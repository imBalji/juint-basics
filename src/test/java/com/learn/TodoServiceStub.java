package com.learn;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {

	@Override
	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn Dance","Learn Spring","Learn Spring Boot");
	}

}