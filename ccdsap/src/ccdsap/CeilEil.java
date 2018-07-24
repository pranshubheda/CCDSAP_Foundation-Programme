package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CeilEil {
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
	
	public static int[] powers = new int[21];

	public static int calcNoOfDishes(int n) {
		
		int result = 0;
		
		for(int i=11; i>=0; i--) {
			while(n>=Math.pow(2, i)) {
				result = (int) (result + n/(Math.pow(2, i)));
				n = (int) (n%(Math.pow(2, i)));
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Inp in = new Inp();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = in.nextInt();
		
		while(t-- > 0) {
			int n = in.nextInt();
			
			int result = calcNoOfDishes(n);
			out.println(result);
		}
		
		out.close();
	}

}
