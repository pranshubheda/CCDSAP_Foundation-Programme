package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ChefNotebook {
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
		
		int t = in.nextInt();
		
		while(t-- > 0) {
			int x = in.nextInt();
			long y = in.nextLong();
			long k = in.nextLong();
			long n = in.nextLong();
			
			long pagesNeeded = x-y;
			
			boolean lucky = false;
			
			while(n-- > 0) {
				int p = in.nextInt();
				int c = in.nextInt();
				
				if(p>=pagesNeeded && c<=k) {
					lucky = true;
					break;
				}
			}
			
			if(lucky)
				out.println("LuckyChef");
			else
				out.println("UnluckyChef");
			
		}
		out.close();
	}

}
