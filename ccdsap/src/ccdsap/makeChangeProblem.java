package ccdsap;

public class makeChangeProblem {
	public static int makeChange(int[] c, int m, int n) {
		
		if(n == 0)
			return 1;
		
		if(n < 0)
			return 0;
		
		if(m<0 && n>=1)
			return 0;
		
		return makeChange(c, m, n-c[m]) + makeChange(c, m-1, n);
	}
	public static void main(String[] args) {
		int[] c = {1,2,3};
		
		int n = 4;
		
		int m=c.length-1;
		
		System.out.println(makeChange(c, m, n));
	}

}
