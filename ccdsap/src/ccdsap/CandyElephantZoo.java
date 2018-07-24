package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CandyElephantZoo {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		String output = "";
		for(int i=1; i<=t; i++) {
			String[] nc = br.readLine().split("\\s");
			int n = Integer.parseInt(nc[0]);
			int c = Integer.parseInt(nc[1]);
			String[] individualCandies = br.readLine().split("\\s");
			int[] candies = new int[n];
			for(int j=0; j<individualCandies.length; j++) {
				candies[j] = Integer.parseInt(individualCandies[j]);
			}
			
			output+= (checkIfPossible(n, c, candies)+ (i==t?"":"\n"));
		}
		
		System.out.print(output);
	}

	public static String checkIfPossible(int n, int c, int[] individualCandies) {
		int alreadyGiven = 0; 
		for(int i=0; i<individualCandies.length; i++) {
			alreadyGiven += individualCandies[i];
		}
		
		if(alreadyGiven > c)
			return "No";
		else
			return "Yes";
	}
}
