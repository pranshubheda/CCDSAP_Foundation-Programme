package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberIncrementer {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split("\\s");
		int[] in = new int[input.length];
		for(int i=0; i<input.length; i++)
			in[i] = Integer.parseInt(input[i]);
		
		int[] output = incrementer(in);
		
		for (int i : output) {
			System.out.print(i);
		}
		
	}
	
	public static int[] incrementer(int[] input) {
		int carry = 1;
		int[] output = new int[input.length];
		for(int i= input.length-1; i>=0; i--) {
			int sum = input[i] + carry;
			if(sum == 10) {
				carry = 1;
			}
			else {
				carry = 0;
				output[i] = sum;
			}
		}
		
		if(carry == 1) {
			output = new int[input.length+1];
			output[0] = 1;
		}
		return output;
	}

}
