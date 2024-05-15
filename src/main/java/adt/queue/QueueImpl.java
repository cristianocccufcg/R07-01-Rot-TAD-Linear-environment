package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		this.array = (T[]) new Object[size];
		this.tail = -1;
	}

	@Override
	public T head() {
		if (isEmpty()) {
			return null;
		} else {
			return array[0];
		}
	}

	@Override
	public boolean isEmpty() {
		return tail == -1;
	}

	@Override
	public boolean isFull() {
		return tail == array.length - 1;
	}

	private void shiftLeft() {
		if (!isEmpty()) {
			for (int i = 0; i < tail; i++) {
				array[i] = array[i + 1];
			}
			array[tail] = null;
			tail--;
		}
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if (isFull()) {
			throw new QueueOverflowException();
		} else {
			array[++tail] = element;
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if (isEmpty()) {
			throw new QueueUnderflowException();
		} else {
			T element = head();
			shiftLeft();
			return element;
		}
	}
}
