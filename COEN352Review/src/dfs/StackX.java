package dfs;

public class StackX {
	private final int SIZE = 20;
	private int[] st;
	private int top;
	
	// constructor
	public StackX() {
		st = new int[SIZE];
		top = -1;
	}
	
	// push
	public void push(int j) {
		st[++top] = j; // push item to stack
	}
	
	// pop
	public int pop() {
		return st[top--];
	}
	
	// peek
	public int peek() {
		return st[top];
	}
	
	// isEmpty
	public boolean isEmpty() {
		return (top == -1);
	}
}// end of class StackX
