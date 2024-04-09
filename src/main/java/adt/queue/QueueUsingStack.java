package adt.queue;

import adt.stack.Stack;
import adt.stack.StackImpl;
import adt.stack.StackOverflowException;
import adt.stack.StackUnderflowException;

public class QueueUsingStack<T> implements Queue<T> {

	private Stack<T> stack1;
	private Stack<T> stack2;

	public QueueUsingStack(int size) {
		stack1 = new StackImpl<T>(size);
		stack2 = new StackImpl<T>(size);
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		} else {
			try {
				stack1.push(element);
			} catch (StackOverflowException e) {
				throw new QueueOverflowException();
			}
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		} else {
			while (!stack1.isEmpty()) {
				try {
					stack2.push(stack1.pop());
				} catch (StackUnderflowException | StackOverflowException e) {
					throw new QueueUnderflowException();
				}
			}

			T result = null;
			try {
				result = stack2.pop();
			} catch (StackUnderflowException e) {
				throw new QueueUnderflowException();
			}

			while (!stack2.isEmpty()) {
				try {
					stack1.push(stack2.pop());
				} catch (StackUnderflowException | StackOverflowException e) {
					throw new QueueUnderflowException();
				}
			}

			return result;
		}
	}

	@Override
	public T head() {
		if (isEmpty()) {
			return null;
		} else {
			while (!stack1.isEmpty()) {
				try {
					stack2.push(stack1.pop());
				} catch (StackUnderflowException | StackOverflowException e) {
					// This should never happen
				}
			}

			T result = stack2.top();

			while (!stack2.isEmpty()) {
				try {
					stack1.push(stack2.pop());
				} catch (StackUnderflowException | StackOverflowException e) {
					// This should never happen
				}
			}

			return result;
		}
	}

	@Override
	public boolean isEmpty() {
		return stack1.isEmpty() && stack2.isEmpty();
	}

	@Override
	public boolean isFull() {
		return stack1.isFull() || stack2.isFull();
	}
}
