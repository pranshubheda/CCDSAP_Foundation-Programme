package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NonDecreesingSubArrayFinding {
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
	public static void main(String[] args) {
		Inp in = new Inp();
		PrintWriter out = new PrintWriter(System.out);
		int t = in.nextInt();
		while(t-- >0) {
			int n = in.nextInt();
			int[] x = new int[n];
			for (int i = 0; i < x.length; i++) {
				x[i] = in.nextInt();
			}
			int ans=n;
			for(int l=0; l<n-1; l++) {
				
				int q = l;
				for(int r=q+1; r<n; r++) {
					if(x[q]<=x[r]) {
						ans++;
						q++;
					}
					else
						break;
				}
			}
			out.println(ans);
		}
		out.close();
	}

}
