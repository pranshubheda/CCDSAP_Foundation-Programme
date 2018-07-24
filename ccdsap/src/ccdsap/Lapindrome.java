package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Lapindrome {
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
			String s= in.next();
			char[] ch = s.toCharArray();
			int n = ch.length;
			ArrayList<Character> list = new ArrayList<>(); 
			for (int i=0; i<n; i++) {
				if(n%2 == 1 && i==n/2)
					continue;
				if(list.contains(ch[i])) {
					list.remove(new Character(ch[i]));
				}
				else
					list.add(ch[i]);
			}
			
			if(list.size() == 0)
				out.println("YES");
			else
				out.println("NO");
		}
		out.close();
	}

}
