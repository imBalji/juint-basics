package com.learn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TodoBusinessImplStubTest {
	
	@Test
	public void testUsingMock() {
		
		TodoService todoServiceMock = mock(TodoService.class);
		stub(todoServiceMock.retrieveTodos("some val.")).toReturn(Arrays.asList("Learn Spring","Learn Spring Boot"));
		
		List<String> filteredTodos = todoServiceMock.retrieveTodos("some val.");
		assertEquals(2, filteredTodos.size());
		
		System.out.println(new TodoBusinessImpl(todoServiceMock).retrieveTodosRelatedToSpring("some val."));
		
	}
	
	@Test
	public void testUsingBDD() {
		// Given
		TodoService todoServiceMock = mock(TodoService.class);
		given(todoServiceMock.retrieveTodos("some val.")).willReturn(Arrays.asList("Learn Spring","Learn Spring Boot"));
		
		// When
		List<String> filteredTodos = todoServiceMock.retrieveTodos("some val.");
		
		// Then
		assertEquals(2, filteredTodos.size());
		
		System.out.println(new TodoBusinessImpl(todoServiceMock).retrieveTodosRelatedToSpring("some val."));
	}
}
