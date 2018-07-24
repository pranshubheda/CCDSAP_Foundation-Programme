package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FencePaint {
	static class Inp {
		BufferedReader br;
		StringTokenizer st;
		
		public Inp() {
			br = new BufferedReader(new InputStreamReader(System.in));
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
			int k = in.nextInt();
			
			String s = in.next();
			
			char[] fence = s.toCharArray();
			
			//StringBuilder fence = new StringBuilder(s);
			
			int result = 0;
			
			for(int i=0; i<n; i++) {
				char ch = fence[i];
				if(ch == 'R') {
					int l = Math.min(n-1, (i+k-1));
					for(int j = i; j<=l; j++) {
						if(fence[j] == 'R')
							fence[j] = 'G';
						else
							fence[j] = 'R';
					}
					result++;
					//System.out.println(fence);
				}
			}
			
			out.println(result);
 		}
		out.close();
	}

}
