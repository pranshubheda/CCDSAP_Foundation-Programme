package ccdsap;

import java.util.Scanner;

public class AlternateSignSubLIS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int[] a = new int[n];
			int[] b = new int[n];
			
			for (int i = 0; i < a.length; i++) {
				a[i] = sc.nextInt() > 0 ? 1 : -1;
			}
			
			b[n-1] = 1;
			for(int i=n-2; i>=0; i--) {
				if((a[i] * a[i+1]) < 0) {
					b[i] = b[i+1] + 1;
				}
				else
					b[i] = 1;
			}
			
			for (int i : b) {
				System.out.print(i+" ");
			}			
			System.out.println();
		}
	}

}
