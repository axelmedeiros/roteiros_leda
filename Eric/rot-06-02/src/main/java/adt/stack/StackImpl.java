package adt.stack;

public class StackImpl<T> implements Stack<T> {

	private static final int ONE = 1;

	private static final int ZERO = 0;

	private static final int NOT_INITIALIZED = -1;

	private final int CAPACITY;

	private T[] array;

	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		// i know you won't try that, but, let's keep it just in case
		if (size < ZERO)
			size = ZERO;
		array = (T[]) new Object[size];
		CAPACITY = size;
		top = NOT_INITIALIZED;
	}

	@Override
	public T top() {
		T element = null;
		if (!isEmpty())
			element = array[top];
		return element;
	}

	@Override
	public boolean isEmpty() {
		return top == NOT_INITIALIZED;
	}

	@Override
	public boolean isFull() {
		return top + ONE == CAPACITY;
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if (isFull())
			throw new StackOverflowException();

		if (element != null) {
			top++;
			array[top] = element;
		}
	}

	@Override
	public T pop() throws StackUnderflowException {
		if (isEmpty())
			throw new StackUnderflowException();

		T element = array[top];
		top--;
		return element;
	}
}
