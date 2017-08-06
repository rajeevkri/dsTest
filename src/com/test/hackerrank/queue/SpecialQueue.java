package com.test.hackerrank.queue;

import java.util.Stack;

//Create a Queue using two stacks
/*
 * Algorithm - 
 * Enqueue Operation

	Push every input element to the Input Stack
	Dequeue Operation

	If ( Output Stack is Empty)
    	pop every element in the Input Stack
    	and push them to the Output Stack until Input Stack is Empty

	pop from Output Stack
 */
public class SpecialQueue<T> {
	Stack<T> stackNewestOnTop = new Stack<T>();
    Stack<T> stackOldestOnTop = new Stack<T>();

    public void enqueue(T value) { // Push onto newest stack
        /*while(!stackOldestOnTop.isEmpty()) {
            T pop = stackOldestOnTop.pop();
            stackNewestOnTop.push(pop);
        }
        stackNewestOnTop.push(value);
        while(!stackNewestOnTop.isEmpty()) {
            T pop = stackNewestOnTop.pop();
            stackOldestOnTop.push(pop);
        }*/
        stackNewestOnTop.push(value);
    }

    public T peek() {
        if(stackOldestOnTop.isEmpty()) {
            while(!stackNewestOnTop.isEmpty()) {
                T pop = stackNewestOnTop.pop();
                stackOldestOnTop.push(pop);
            }

        }
        return stackOldestOnTop.peek();
    }

    public T dequeue() {
        if(stackOldestOnTop.isEmpty()) {
            while(!stackNewestOnTop.isEmpty()) {
                T pop = stackNewestOnTop.pop();
                stackOldestOnTop.push(pop);
            }
        }
        return stackOldestOnTop.pop();
    }
}
