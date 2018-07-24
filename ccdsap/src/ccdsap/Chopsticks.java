package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Chopsticks {
	static class Inp {
		BufferedReader br;
		StringTokenizer st;
		
		public Inp() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			while(st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		Long nextLong() {
			return Long.parseLong(next());
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
	}
	public static void main(String[] args) {
		Inp in = new Inp();
		PrintWriter out = new PrintWriter(System.out);
		
		int n = in.nextInt();
		int d = in.nextInt();
		
		int[] a = new int[n];
		
		for (int i = 0; i < a.length; i++) {
			a[i] = in.nextInt();
		}
		
		int result = 0;
		
		Arrays.sort(a);
		
		for (int i = 0; i < a.length-1; ) {
			if(Math.abs(a[i+1] - a[i]) <= d ) {
				i+=2;
				result++;
			}
			else
				i++;
				
		}
		
		out.print(result);
		
		out.close();
		

	}

}
