package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ManyChefSignBoard {
	static class Input {
		BufferedReader br;
		StringTokenizer st;
		
		Input() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String next() {
			if(st==null || !st.hasMoreElements()) {
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
 
        double nextDouble() {
            return Double.parseDouble(next());
        }
	}
	public static void main(String[] args) {
		try {
			Input in = new Input();
			PrintWriter out = new PrintWriter(System.out);
			
			int t = in.nextInt();
			
			while(t-->0) {
				String inpString = null;
				inpString = in.next();
				char[] s = inpString.toCharArray();
				
				for(int i=s.length-1;i>=3;i--)
				{
					if((s[i]=='F'||s[i]=='?')&&(s[i-1]=='E'||s[i-1]=='?')&&(s[i-2]=='H'||s[i-2]=='?')&&(s[i-3]=='C'||s[i-3]=='?'))
					{
						s[i-3]='C';
						s[i-2]='H';
						s[i-1]='E';
						s[i]='F';
					}
				}
				
				for (char ch : s) {
					if(ch=='?')
						out.print("A");
					else
						out.print(ch);
				}
				out.println();
			}
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

}
