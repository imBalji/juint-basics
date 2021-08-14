package com.learn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class TodoBusinessImplMockTest {
	
	@Test
	public void testUsingStub() {
		TodoServiceStub todoServiceStub = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceStub);
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("some val.");
		assertEquals(2, filteredTodos.size());
	}
}
