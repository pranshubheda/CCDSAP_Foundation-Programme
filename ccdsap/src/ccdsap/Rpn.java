package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Rpn {

	static final int max = 400;
	
	static char[] stack;
	
	static char[] operators = {'+', '-', '*', '/', '^'};
	
	static int top = -1;

	static void push(char x) {
		if(top < max) {
			stack[++top] = x;
		}
	}
	
	static char pop() {
		return stack[top--];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCaseCount = Integer.parseInt(br.readLine());
		String[] expressionArray = new String[testCaseCount];
		String[] resultArray = new String[testCaseCount];

		for(int i=0; i<testCaseCount; i++) {
			String expression = br.readLine();
			expressionArray[i] = expression;
		}
		
		for(int i=0; i<testCaseCount; i++) {
			top =-1;
			stack = new char[max];
			String result = "";
			String expression = expressionArray[i];
			for(int j=0; j<expression.length(); j++) {
				char x = expression.charAt(j);
				if((int)x>='a' && (int)x<='z') {
					result+=x;
				}
				else if(x=='(' || x=='+'|| x=='-'|| x=='*'|| x=='/'|| x=='^') {
					push(x);
				}
				else if(x==')') {
					char ch = pop();
					while(ch!='(' && top>-1) {
						result+=ch;
						ch = pop();
					}
				}
			}
			resultArray[i] = result;
		}
		
		for (String result : resultArray) {
			System.out.println(result);
		}
	}
}
