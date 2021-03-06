package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Mock1P4 {
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
			
			int[] a = new int[n];
			int[] result = new int[n];
			
			for (int i = 0; i < a.length; i++) {
				a[i] = in.nextInt() > 0 ? 1 : -1;
			}
			
			result[n-1] = 1;
			
			for(int i=n-2; i>=0; i--) {
				if(a[i] * a[i+1] < 0) {
					result[i] = result[i+1] + 1;
				}
				else
					result[i] = 1;
			}
			
			for (int j = 0; j < result.length; j++) {
				out.print(result[j]+" ");
			}
			
			out.println();
		}
		out.close();
	}

}
