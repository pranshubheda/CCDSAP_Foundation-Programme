package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CakeRotateCherry {
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
		
		
		try {
			while (t-- > 0) {
				int k = in.nextInt();
				
				String s = in.next();
				
				StringBuilder result = new StringBuilder(s);
				
				if (result.length() == 1 ) {
					if(result.charAt(0) == '?') {
						result = new StringBuilder("0");
					}
					out.println(result);
					continue;
				}
				
				if ((result.charAt(0) != result.charAt(result.length() - 1)) || (result.charAt(0) == '?' && result.charAt(result.length() - 1) == '?')) {
					
					outer:
						for (int i = 0; i < result.length(); i++) {
							//first char
							if (i == 0 && result.charAt(i) == '?') {
								for (int j = 0; j < k; j++) {
									if(String.valueOf(j).charAt(0) != result.charAt(result.length()-1) && String.valueOf(j).charAt(0) != result.charAt(1)) {
										result.setCharAt(0, String.valueOf(j).charAt(0));
										continue outer;
									}
								}
							}
							
							//last char
							if (i == result.length()-1 && result.charAt(i) == '?') {
								for (int j = 0; j < k; j++) {
									if(String.valueOf(j).charAt(0) != result.charAt(0) && String.valueOf(j).charAt(0) != result.charAt(result.length()-2)) {
										result.setCharAt(result.length()-1, String.valueOf(j).charAt(0));
										continue outer;
									}
								}
							}
							
							//middle char
							if (result.charAt(i) == '?') {
								for (int j = 0; j < k; j++) {
									if (result.charAt(i - 1) != String.valueOf(j).charAt(0) && result.charAt(i + 1) != String.valueOf(j).charAt(0)) {
										result.setCharAt(i, String.valueOf(j).charAt(0));
										continue outer;
									}
								}
							}
							
						}
				
				} else {
					result = new StringBuilder("NO");
				}
				
				out.println(result);
				
			}
			
			out.close();
			
		}
		catch (Exception e) {
			return;
		}
	}

}
