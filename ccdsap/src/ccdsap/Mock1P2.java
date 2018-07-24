package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Mock1P2 {
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
			String l = in.next();
			
			StringBuilder s1;
			StringBuilder s2;
			
			if(l.length()%2 == 0) { 
				s1 = new StringBuilder(l.substring(0, (l.length())/2));
				s2 = new StringBuilder(l.substring((l.length())/2));
			}else {
				s1 = new StringBuilder(l.substring(0, (l.length())/2));
				s2 = new StringBuilder(l.substring((l.length()+1)/2));
			}
			
			boolean yes = true;
			for(int i=0; i<s1.length(); i++) {
				char ch = s1.charAt(i);
				int q = s2.indexOf(""+ch);
				
				if(q==-1){
					out.println("NO");
					yes = false;
					break;
				}
				s2.deleteCharAt(q);
			}
			
			if(yes) {
				out.println("YES");
			}
			
		}
		out.close();
	}

}
