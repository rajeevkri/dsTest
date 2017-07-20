package com.test.stack;

import java.util.Stack;

import org.junit.Test;

public class OperationsTest {

	@Test
	public void testSortStack() {
		Stack<Integer> stack = new Stack<>();
		stack.push(2);
		stack.push(4);
		stack.push(3);
		stack.push(5);
		stack.push(7);
		stack.push(1);
		stack.push(6);
		
		Operations ops = new Operations();
		Stack<Integer> sortedStack = ops.sortStack(stack);
		while (!sortedStack.isEmpty()) {
			System.out.println(sortedStack.pop());
		}
	}
}
