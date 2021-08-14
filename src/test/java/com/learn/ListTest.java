package com.learn;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

import java.util.List;

import org.junit.jupiter.api.Test;

class ListTest {

	@Test
	void testMockList() {
		List<?> mList = mock(List.class);
		stub(mList.size()).toReturn(2);
		assertEquals(2, mList.size());
	}

	@Test
	void testMockList2() {
		List<?> mList = mock(List.class);
		stub(mList.size()).toReturn(2).toReturn(3);
		assertEquals(2, mList.size()); // For the first time it returns 2
		assertEquals(3, mList.size()); // The second time it returns 3
	}

	@Test
	void testMockList3() {
		List mList = mock(List.class);
		stub(mList.get(0)).toReturn("The initial index value of list");
		assertEquals("The initial index value of list", mList.get(0));
		assertEquals(null, mList.get(1));
	}

	@Test()
	void testMockList4() {
		List mList = mock(List.class);
		stub(mList.get(anyInt())).toReturn("The initial index value of list");
		assertEquals("The initial index value of list", mList.get(0));
		assertEquals("The initial index value of list", mList.get(1));
	}
}