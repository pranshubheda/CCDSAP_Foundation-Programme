package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LPlusPlus {
	
	static final int max = 1000000;

	static int[] results;
	
	static char[] stack;
	
	static char[] operators = {'+', '-', '*', '/', '^'};
	
	static int top = -1;

	static void push(char x) {
		if(top < max) {
			stack[++top] = x;
		}
	}
	
	static char pop() {
		if(top > -1)
			return stack[top--];
		else
			return '0';
	}
			
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		results = new int[t];
		for(int i=0; i<t; i++) {
			int resultCtr=0;
			stack = new char[max];
			top = -1;
			String expression = br.readLine();
			for(int j=0; j<expression.length(); j++) {
				char x = expression.charAt(j);
				if(x=='<')
					push(x);
				else if(x=='>') {
					char popped = pop();
					if(popped == '<')
						resultCtr += j;
				}
			}
			results[i] = resultCtr;
		}
		
		for (int result : results) {
			System.out.println(result);
		}
	}

}
