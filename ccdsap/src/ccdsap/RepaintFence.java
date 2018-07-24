package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class RepaintFence {
	static class Inp{
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
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
	}
	public static void main(String[] args) throws IOException {
		Inp in = new Inp();
		PrintWriter out = new PrintWriter(System.out);
		int t = in.nextInt();
		while(t-- > 0 ) {
			int n = in.nextInt();
			int k = in.nextInt();
			
			String s = in.next();
			char[] c = s.toCharArray();
			
			//min(N, X+K-1)
			int p1 = 0;
			int p2 = c.length;
			int ctr=0;
			for(int i=0; i<n; i++) {
				
				boolean flag = true;
				for(int l=p1; l<n; l++) {
					if(c[l]=='R') {
						p1=l;
						ctr++;
						flag=false;
						break;
					}
				}
				
				if(flag)
					break;
				
				p2 = (n<(p1+k)?n:(p1+k));
				
				for(int j=p1; j<p2; j++) {
					if(c[j]=='R') {
						c[j]='G';
					}
					else {
						c[j]='R';
					}
				}
			}
			
			out.println(ctr);
		}
		out.close();
	}

}
