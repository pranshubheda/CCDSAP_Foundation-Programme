package ccdsap;

import java.util.Scanner;

public class FibMemoization {

	public static int[] lookup;
	public static int fibMem(int n) {
		if(lookup[n] == -1) {
			if(n<=1) {
				lookup[n] = n;
			}
			else {
				lookup[n] = fibMem(n-1) + fibMem(n-2);
			}
		}
		return lookup[n];
	}
	
	public static void main(String[] args) {
		//top-down
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		lookup  = new int[n+1];
		for (int i = 0; i < lookup.length; i++) {
			lookup[i] = -1;
		}
		System.out.println(fibMem(n));
	}

}
