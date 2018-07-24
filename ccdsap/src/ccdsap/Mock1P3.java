package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Mock1P3 {
	static class Inp {
		BufferedReader br;
		StringTokenizer st;

		public Inp() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
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
				
		int t = in.nextInt();
		
		while(t-- > 0) {
			int n = in.nextInt();
			int k = in.nextInt();
			
			int[] a = new int[n];
			int s = 0;
			for (int i = 0; i < a.length; i++) {
				a[i] = in.nextInt();
				s += a[i];
			}
			
			Arrays.sort(a);
			
			int s1 = 0;
			int s2 = 0;
			
			for(int i=0; i<k; i++) {
				s1 += a[i];
			}
			
			for(int i=n-1; i>n-1-k; i--) {
				s2 += a[i];
			}
			
			int result = Math.max(Math.abs(s2-(s-s2)), Math.abs(s1-(s-s1)));
			
			out.println(result);
		}
		out.close();
	}

}
