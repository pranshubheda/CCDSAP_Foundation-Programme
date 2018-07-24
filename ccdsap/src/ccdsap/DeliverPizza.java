package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class DeliverPizza {
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
	
	public static long calcMin(int[] k, int v) {
		if(v==0)
			return 0;
		
		if(memo.containsKey(v))
			return memo.get(v);
		
		long result = Integer.MAX_VALUE;
		
		for(int i=0; i<k.length; i++) {
			if(k[i] <= v) {
				long subResult = calcMin(k, v-k[i]);
				if(subResult != Integer.MAX_VALUE && subResult +1<result)
					result = subResult +1;
			}
		}
		
		memo.put(v, result);
		return result;
	}
	
	public static HashMap<Integer, Long> memo = new HashMap<>();
 	
	public static void main(String[] args) {
		Inp in = new Inp();
		PrintWriter out = new PrintWriter(System.out);
		int t = in.nextInt();
		while(t-- > 0) {
			int n = in.nextInt();
			int[] h = new int[n];
			
			//int totalPetrol = 0;
			for(int i=0; i<n; i++) {
				h[i] = in.nextInt();
				//totalPetrol+=h[i];
				
			}
			
			
			long sum = 0;
			
			int[] k = new int[n];
			for(int i=0; i<n; i++) {
				k[i] = in.nextInt();
			}
			
			for(int i=0; i<n; i++) {
				sum += calcMin(k, h[i]*2);
			}
			
			out.println(sum);
		}
		
		out.close();
	}

}
