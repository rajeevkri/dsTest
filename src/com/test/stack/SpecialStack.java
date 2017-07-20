package com.test.stack;

import java.util.Stack;

/**
 * Design a Data Structure SpecialStack that supports all the stack operations
 * like push(), pop(), isEmpty(), isFull() and an additional operation getMin()
 * which should return minimum element from the SpecialStack. All these
 * operations of SpecialStack must be O(1). To implement SpecialStack, you
 * should only use standard Stack data structure and no other data structure
 * like arrays, list, .. etc.
 * 
 */
public class SpecialStack extends Stack<Integer> {

	Stack<Integer> min = new Stack<>();

	@Override
	public Integer push(Integer item) {
		Integer m = getMin();
		if (item < m) {
			min.push(item);
		}
		return super.push(item);
	}

	@Override
	public synchronized Integer pop() {
		Integer pop = super.pop();
		Integer m = getMin();
		if (pop == m) {
			min.pop();
		}
		return pop;
	}

	public Integer getMin() {
		if (!min.isEmpty()) {
			Integer m = min.peek();
			return m;
		}
		return null;
	}
}
