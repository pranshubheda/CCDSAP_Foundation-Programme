package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class CoinChange {
	static class Inp{
		BufferedReader  br;
		StringTokenizer st;
		Inp() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while (st==null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
	}

	static int result = 99999999;

	static int subresult = 0;
	
	private static int calculate(Integer[] c, int value) {
		if(value == 0) {
			return 0;
		}
		
		for(int i=0; i<c.length; i++) {
			if(c[i] <= value) {
				subresult = calculate(c, value-c[i]);

				if(subresult+1 < result)
					result = subresult+1;
			}
		}

		
		return result;
	}
	
    static int minCoins(int[] c, int m, int V)
    {
       if(V==0)
    	   return 0;
       
       int res = Integer.MAX_VALUE;
       
       for(int i=0; i<m; i++) {
    	   if(c[i]<=V) {
    		   int sub_res = minCoins(c, m, V-c[i]);
    		   
    		   if(sub_res != Integer.MAX_VALUE && sub_res+1 < result) {
    			   result = sub_res +1;
    		   }
    	   }
       }
       
       return result;
    }
	
	
	public static void main(String[] args) {
		int coins[] =  {9, 6, 5, 1};
		int m = coins.length;
		int V = 11;
		System.out.println("Minimum coins required is "+ minCoins(coins, m, V) );
	}
}
