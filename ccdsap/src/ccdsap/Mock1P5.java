package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Mock1P5 {
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
		long t = in.nextInt();
		
		while(t-- > 0) {
			int ctr = 0;
			long n = in.nextLong();
			String s = in.next();
			
			for (long i = 0; i < s.length(); i++) {
				if(s.charAt((int)i) == '1')
					ctr++;
			}
			int result = (ctr*(ctr+1))/2;
			out.println(result);
		}
		out.close();
	}

}
