package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AlternatingSignSubarray {
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
			int n = in.nextInt();
			int[] a = new int[n];
			int[] b = new int[n];
			
			int x = 0;
			b[0] = 1;
			
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt() > 0 ? 1 : -1;
			}
			
			int[] c = new int[n];
			int sum = 0;
			c[n-1] = 1;
			for(int i=n-2; i>=0; i--) {
				if(a[i] != a[i+1]) {
					c[i] = c[i+1] +1;
				}
				else
					c[i] = 1;
			}
			
			/*b[n-1] = 1;
			
			for(int i=0; i<n-1; i++) {
				int p = i;
				int ans = 1;
				for(int j=i+1; j<n; j++) {
					if(a[p] != a[j]) {
						ans++;
						p++;
					}
					else {
						break;
					}
				}
				b[i] = ans;
			}*/	
			
			for (int i : c) {
				out.print(i+" ");
			}
			out.println();
		}
		out.close();
	}

}
