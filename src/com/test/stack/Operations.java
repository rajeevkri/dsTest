package com.test.stack;

import java.util.Stack;

public class Operations {

	public Stack<Integer> sortStack(Stack<Integer> stack) {
		Stack<Integer> helperStack = new Stack<>();
		while(!stack.isEmpty()) {
			Integer elem = stack.pop();
			while(!helperStack.isEmpty() && helperStack.peek() > elem) {
				stack.push(helperStack.pop());
			}
			helperStack.push(elem);
		}
		return helperStack;
	}
}
