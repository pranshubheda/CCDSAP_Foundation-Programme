package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Delish {
	static class Inp {
		BufferedReader br;
		StringTokenizer st;
		
		public Inp() {
			br = new BufferedReader( new InputStreamReader(System.in));
		}
		
		String next() {
			while(st==null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
	}
	public static void main(String[] args) {
		Inp in = new Inp();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = in.nextInt();
		
		while(t-- > 0) {
			int n = in.nextInt();
			long[] a = new long[n];
			int s = 0;
			
			for (int i = 0; i < a.length; i++) {
				a[i] = in.nextLong();
				s+=a[i];
 			}
			
			Arrays.sort(a);
			long s1 = a[0];
			
			for (int i = 1; i <= a.length-2 ; i++) {
				if(s1 + a[i] < s1)
					s1+=a[i];
				else
					break;
 			}
			
			long s2 = s-s1;
			long result = s2-s1;
			out.println(result);
		}
		out.close();
	}

}
