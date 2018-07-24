package ccdsap;

import java.util.Scanner;

public class FibTabulation {
	
	public static int[] lookup;
	public static int fiboTab(int n) {
		lookup[0] = 0;
		lookup[1] = 1;
		
		for(int i=2; i<=n; i++) {
			lookup[i] = lookup[i-1] + lookup[i-2];
		}
		return lookup[n];
	}
	public static void main(String[] args) {
		// bottom-up
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		lookup = new int[n+1]; 
		
		System.out.println(fiboTab(n));
	}

}
