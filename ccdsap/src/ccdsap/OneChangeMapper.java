package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class OneChangeMapper {
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
			String s = in.next();
			char[] ch = s.toCharArray();
			int sum=0;
			int n = ch.length;
			int[] x = new int[n];
			for(int i=0; i<n; i++) {
				x[i] = Character.getNumericValue(ch[i]);
				sum+=x[i];
			}
			
			if(sum == 0) {
				out.println("NO");
				continue;
			}
			
			int sum2 = 0;
			outerloop:
			for (int i = 0; i < x.length; i++) {
				if(x[i] ==1) {
					for(int j=i; j<n; j++) {
						if(x[j] == 1)
							sum2++;
						else
							break outerloop;
						if(j==n-1)
							break outerloop;
					}
				}
			}
			
			if(sum == sum2) {
				out.println("YES");
			}
			else
				out.println("NO");
		}
		out.close();
	}

}
