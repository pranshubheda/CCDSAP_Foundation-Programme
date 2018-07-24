package ccdsap;

import java.util.Scanner;

public class NaiveStringSearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String text = "AABAACAADAABAAABAA";
		
		String pattern = "AABA";
		
		int m = text.length();
		
		int n = pattern.length();
		
		for(int i=0; i<=(m-n); i++) {
			
			int j;
			
			for(j=0; j<n; j++) {
				if(text.charAt(i+j) != pattern.charAt(j))
					break;
			}
			
			if(j==n)
				System.out.println("Pattern found at index "+i);
			
		}
		
	}

}
