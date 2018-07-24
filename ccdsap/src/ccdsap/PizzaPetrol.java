package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import javax.naming.spi.DirStateFactory.Result;

public class PizzaPetrol {
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
	
	static int findMin(Integer[] k, int no, int x) {
		
		if(x==0)
			return 0;
		
		for(int j=0; j<k.length; j++) {
			
			if(k[j]<=no) {
				int subResult = findMin(k, k[j], no-k[j]) + 1;
				
				if(subResult+1<result) {
					result = subResult+1;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Inp in = new Inp();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = in.nextInt();
		while(t-- > 0) {
			int n = in.nextInt();
			int[] h = new int[n];
			Integer[] k = new Integer[n];
			
			for (int i = 0; i < n; i++) {
				int x = in.nextInt();
				h[i] = 2*x;
			}
			
			for (int i = 0; i < n; i++) {
				k[i] = in.nextInt();
			}
			
			Arrays.sort(k, Collections.reverseOrder());
			
			int sum = 0;
			
			for(int i=0; i<n; i++) {
				int no = h[i];
				
				sum += findMin(k, no, no);
				
			}
			out.print(sum);
			out.close();
		}
	}

}
