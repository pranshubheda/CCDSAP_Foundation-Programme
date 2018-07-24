package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Mock1P1 {
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
			
			int result = 0;
			
			for(int i=0; i<n; i++) {
				a[i] = in.nextInt() + k;
				
				if(a[i]%7 == 0)
					result++;
			}
			
			out.println(result);
		}
		
		out.close();
	}

}
