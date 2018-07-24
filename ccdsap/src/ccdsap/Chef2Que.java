package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Chef2Que {
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
		
		int t = in.nextInt();
		
		while(t-- > 0) {
			int n1 = in.nextInt();
			int n2 = in.nextInt();
			
			int k = in.nextInt();
			
			int result = 0;
			
			int maxRemoved = (k * (k+1))/2;
			
			result = Math.min(maxRemoved, Math.min(n1, n2));
			
			out.println(result);
		}
		
		out.close();
	}

}
