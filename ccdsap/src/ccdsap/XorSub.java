package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class XorSub {
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
	
	public static void findSubsets(int[] a, int v) {
		
	}
	
	public static void main(String[] args) {
		Inp in = new Inp();
		PrintWriter out = new PrintWriter(System.out);
		int t = in.nextInt();
		while(t-- > 0) {
			int n = in.nextInt();

			int k = in.nextInt();
			
			int[] a = new int[n];
			
			for (int i = 0; i < a.length; i++) {
				a[i] = in.nextInt();
			}
			
			//int[] a = {1,2,3};
			
			
			ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
			
			ArrayList<ArrayList<Integer>> xorlists = new ArrayList<>();
			
			ArrayList<Integer> emptySet = new ArrayList<Integer>();
			
			ArrayList<Integer> emptySetXOR = new ArrayList<Integer>();
			
			emptySet.add(0);
			
			emptySetXOR.add(k);
			
			lists.add(emptySet);
			
			xorlists.add(emptySetXOR);
			
			int result = 0;
			
			for(int v : a) {
				int n1 = lists.size();
				
				for(int i=0; i<n1; i++) {
					ArrayList<Integer> newList = new ArrayList<>();
					ArrayList<Integer> internalList = lists.get(i);
					
					int internalXOR = internalList.get(0) ^ v;
					
					int finalXOR = internalXOR ^ k;
					
					if(finalXOR >result)
						result = finalXOR;
					
					newList.add(internalXOR);
					lists.add(newList);
					
					newList = new ArrayList<>();
					
					newList.add(finalXOR);
					xorlists.add(newList);
				}
			}
			
			out.println(result);
		}
		
		out.close();
		
	}

}
