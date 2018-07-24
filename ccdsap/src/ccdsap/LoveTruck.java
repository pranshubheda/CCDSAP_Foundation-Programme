package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TestStack {
	
	int index;
	
	static final int max = 1000;
	
	int[] stack = new int[1000];
	
	int top = -1;

	void push(int x) {
		if(top < max) {
			stack[++top] = x;
			index++;
		}
	}
	
	int pop() {
		if(top>-1)
			return stack[top--];
		else {
			System.err.println("Stack is Empty exiting");
			System.exit(0);
			return -1;
		}
	}
	
	void printStack() {
		for (int i : stack) {
			System.err.print(i+" ");
		}
		System.out.println();
	}
	
	int getStackLength() {
		return stack.length;
	}
	
	int getTop() {
		return top;
	}
}

public class LoveTruck {
	
	/**
	 * @param args
	 * @throws NumberFormatException
	 * @throws IOException
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strNums;
		strNums = br.readLine().split("\\s");
		TestStack inputStack = new TestStack();
		for (int i=strNums.length-1; i>=0; i--) {
			int x = Integer.parseInt(strNums[i]);
			inputStack.push(x);
		}
		
		TestStack standBy = new TestStack();
		TestStack output = new TestStack();
		
		int inputStackLength = inputStack.index;
		while(inputStackLength-- != 0) {
			int popped = inputStack.pop();
			if(popped == output.index+1) {
				output.push(popped);
			}
			else {
				standBy.push(popped);
			}
		}
		
		int standByStackLength = standBy.index;
		while(standByStackLength-- != 0) {
			int popped = standBy.pop();
			if(popped == output.index+1) {
				output.push(popped);
			}
			else {
				standBy.push(popped);
			}
		}
		
		if(standBy.getTop() > -1)
			System.out.println("No");
		else
			System.out.println("Yes");
	
	}

}
