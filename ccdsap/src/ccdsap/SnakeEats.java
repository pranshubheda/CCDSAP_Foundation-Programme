package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class SnakeEats {
	static class Inp {
		BufferedReader br;
		StringTokenizer st;	
		Inp(){
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
		
		long nextLong()
		{
			return Long.parseLong(next());
		}
		int nextInt()
		{
			return Integer.parseInt(next());
		}
		
		double nextDouble() {
            return Double.parseDouble(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
	}
	
	public static void main(String[] args) {
		Inp inp = new Inp();
		PrintWriter out = new PrintWriter(System.out);
		
		int t = inp.nextInt();
		for(int i=0; i<t; i++) {
			int n = inp.nextInt();
			int q = inp.nextInt();
			
			long[] snakes = new long[n];
			for(int j=0; j<n; j++) {
				snakes[j] = inp.nextLong();
			}
			Arrays.sort(snakes);
/*			long[] queries = new long[q];
			for(int j=0; j<q; j++) 
				queries[j] = inp.nextLong();
*/			
			long max = snakes[n-1] + n - 1;

			HashMap<Long, Integer> map = new HashMap<>();
			
			while(q-->0) {
				long k = inp.nextLong();

				if(k > max) {
					out.println("0");
					continue;
				}
				
				if(map.containsKey(k)) {
					out.println(map.get(k));
					continue;
				}
				
				int p1 = 0;
				int p2 = Arrays.binarySearch(snakes, k);
				int ans = 0;
				
				if(p2 < 0 ) {
					p2 = -p2-2;
				}
				else {
					p2 = p2-1;
				}
				
				ans += n-p2-1;
				
				for (int j = p2; j >= p1; j--) {
					if(k-snakes[j] <= j-p1) {
						ans++;
                        p1 += (int) k-snakes[j];
					}
					else
						break;
				}
				map.put(k, ans);
				out.println(ans);
			}
		}
		out.close();
	}

}
