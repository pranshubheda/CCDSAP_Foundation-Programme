package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChefSock {
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
	public static void main(String[] args) {
		Inp in = new Inp();
		int jacketCost = in.nextInt();
		int sockCost = in.nextInt();
		int money = in.nextInt();
		
		int sockMoney = money - jacketCost;
		
		if(((int)sockMoney/sockCost)%2 == 0)
			System.out.println("Lucky Chef");
		else
			System.out.println("Unlucky Chef");
	}

}
