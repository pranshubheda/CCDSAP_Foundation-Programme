package ccdsap;

public class minMakeChangeProblem {

	public static int minMakeChange(int[] c, int m, int v) {
		
		if(v == 0)
			return 0;
		
		int result = Integer.MAX_VALUE;
		
		for(int i=0; i<m; i++) {
			if(c[i] <= v) {
				int subResult = minMakeChange(c, m, v-c[i]);
				
				if(subResult + 1 < result)
					result = subResult + 1;
			}
		}
		
		
		return result;
	}
	
	public static void main(String[] args) {
		
		int[] c = {9, 6, 5, 1};
		int v = 11;
		int m = c.length;
		
		System.out.println(minMakeChange(c, m, v));
	}

}
