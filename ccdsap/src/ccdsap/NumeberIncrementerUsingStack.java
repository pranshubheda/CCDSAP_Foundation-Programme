package ccdsap;

import java.util.ArrayList;
import java.util.Scanner;

public class NumeberIncrementerUsingStack {
	
	static int max = 1000000;
	static int[] stack = null;
	static int top=-1;
	static int length=0;
	
	static private void traverse(ArrayList<String> results) {
		String result = "";
		if(stack[0] == 0)
			result+="1";
		for(int i=0; i<length; i++)
			result+=stack[i];
		results.add(result);
	}
	
	static private void push(int x) {
		if(top>max)
			System.err.println("Stack Overflow");
		else
			stack[++top] = x;
	}
	
	static private int pop() {
		if(top<0) {
			System.err.println();
			return -1;
		}
		else {
			return stack[top--];
		}
	}
	
	static private void replace(int x) {
		stack[top+1] = x;
	}
	
	private static String split(String numberString) {
		String trimmedNumberString = "";
		for(int i=0; i<numberString.length(); i++) {
			if(numberString.charAt(i) == ' ')
				continue;
			else {
				push(Integer.parseInt((numberString.charAt(i)+"")));
				trimmedNumberString+=numberString.charAt(i);
			}
		}
		return trimmedNumberString;
	}
	
	private static void calculate() {
		int popped= pop();
		if(popped != 9) {
			replace(++popped);
		}
		else {
			replace(0);
			calculate();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCaseCount = 0;
		testCaseCount = sc.nextInt();
		sc.nextLine();
		ArrayList<String> results = new ArrayList<>();
		while(testCaseCount-- != 0) {
			stack = new int[max];
			top=-1;
			length = sc.nextInt();
			sc.nextLine();
			String numberString = sc.nextLine();
			String trimmedNumberString = split(numberString);
			calculate();
			traverse(results);
		}
		for (String result : results) {
			System.out.println(result);
		}
	}
}
