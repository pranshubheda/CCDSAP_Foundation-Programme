package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RainbowArray {
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
		
		while(t-- > 0) {
			int n = in.nextInt();
			int[] x = new int[n];
			for (int i = 0; i < n; i++) {
				x[i] = in.nextInt();
			}
			
			int lastIndex = n-1;
			boolean flag = true;
			int prev = 0;
			int middle = n/2;
			for (int i = 0; i <= middle; i++) {
				if(x[i] != x[lastIndex-i] || (Math.abs(prev-x[i]) > 1) || (x[middle]!=7)) {
					flag =false;
					out.println("no");
					break;
				}
				prev =x[i];
			}
			
			if(flag)
				out.println("yes");
		}
		
		out.close();
	}

}
