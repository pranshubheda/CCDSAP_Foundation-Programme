package ccdsap;

public class CoinChange2 {
	
	public static int minCoins(int[] c, int m, int v) {
		if(v == 0)
			return 0;
		
		int result = Integer.MAX_VALUE;
		
		for(int i=0; i<m; i++) {
			if(c[i] <= v) {
				int subresult = minCoins(c, m, v-c[i]);
				
				if(subresult+1< result)
					result = subresult+1;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		int[] c = {9, 6, 5, 1};
		int v = 11;
		int m = c.length;
		
		int x = minCoins(c, m, v);
		System.out.println(x);
	}
}
