package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class StonesGame {
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
		
		while (t-- >0) {
			long x = in.nextLong();
			long y  = in.nextLong();
			long m = in.nextLong();
			
			long q = m * (m+1)/2;
			
			long min = -1;
			
			long k = Math.min(x, y);
			
			if(k <= q) {
				min = k;
			}else {
				min = q;
			}
			
			x-=min;
			y-=min;
			/*for(int i=1; i<=n; i++) {
				if(x>=i && y>=i) {
					x-=i;
					y-=i;
				}
				else
					break;
			}*/
			
			out.println(x+y);
		}
		out.close();
	}

}
