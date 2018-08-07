package com.test.stack;

import java.util.Stack;

public class Operations {

	public Stack<Integer> sortStack(Stack<Integer> stack) {
		Stack<Integer> helperStack = new Stack<>();
		while (!stack.isEmpty()) {
			Integer elem = stack.pop();
			while (!helperStack.isEmpty() && helperStack.peek() > elem) {
				stack.push(helperStack.pop());
			}
			helperStack.push(elem);
		}
		return helperStack;
	}

	public int maxHistogram(int[] input) {
		Stack<Integer> stack = new Stack<Integer>();
		int maxArea = 0;
		int area = 0;
		int i;
		for (i = 0; i < input.length;) {
			if (stack.isEmpty() || input[stack.peek()] <= input[i]) {
				stack.push(i++);
			} else {
				int top = stack.pop();
				// if stack is empty means everything till i has to be
				// greater or equal to input[top] so get area by
				// input[top] * i;
				if (stack.isEmpty()) {
					area = input[top] * i;
				}
				// if stack is not empty then everything from i-1 to input.peek() + 1
				// has to be greater or equal to input[top]
				// so area = input[top]*(i - stack.peek() - 1);
				else {
					area = input[top] * (i - stack.peek() - 1);
				}
				if (area > maxArea) {
					maxArea = area;
				}
			}
		}
		while (!stack.isEmpty()) {
			int top = stack.pop();
			// if stack is empty means everything till i has to be
			// greater or equal to input[top] so get area by
			// input[top] * i;
			if (stack.isEmpty()) {
				area = input[top] * i;
			}
			// if stack is not empty then everything from i-1 to input.peek() + 1
			// has to be greater or equal to input[top]
			// so area = input[top]*(i - stack.peek() - 1);
			else {
				area = input[top] * (i - stack.peek() - 1);
			}
			if (area > maxArea) {
				maxArea = area;
			}
		}
		return maxArea;
	}
	
	public static void main(String args[]){
		Operations mh = new Operations();
        int input[] = {2,2,2,6,1,5,4,2,2,2,2};
        int maxArea = mh.maxHistogram(input);
        //System.out.println(maxArea);
        assert maxArea == 12;
    }
}
