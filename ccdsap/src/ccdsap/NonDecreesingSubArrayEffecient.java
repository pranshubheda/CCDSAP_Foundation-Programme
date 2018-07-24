package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NonDecreesingSubArrayEffecient {
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
		int t = in.nextInt();
		PrintWriter out = new PrintWriter(System.out);
		
		while(t-- > 0) {
			int n = in.nextInt();
			int[] a = new  int[n];
			for (int i = 0; i < a.length; i++) {
				a[i] = in.nextInt();
			}
			int[] b = new  int[n];
			b[0] = 1;
			
			for (int i = 1; i < a.length; i++) {
				if(a[i] >= a[i-1]) {
					b[i] = b[i-1] +1;
				}
				else
					b[i] = 1;
			}
			
			int sum=0;
			for (int i : b) {
				sum +=i;
			}
			out.println(sum);
		}
		
		out.close();
	}

}
