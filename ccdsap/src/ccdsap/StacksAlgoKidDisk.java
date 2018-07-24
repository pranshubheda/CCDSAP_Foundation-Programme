package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StacksAlgoKidDisk {

	public static int[] stackHeads;
	
	public static int top;
	
	public static void compareAndPlace(int j) {
		int low = 0;
		int high = top;
		int replaceIndex = top;
		int mid = 0;
		while(low<=high) {
			mid = (high+low)/2;
			if(stackHeads[mid] == 0)
				break;
			if(stackHeads[mid] > j) {
				replaceIndex = mid;
				high = mid-1;
			}
			else {
				low = mid+1;
			}
		}
		if(replaceIndex!=top)
			stackHeads[replaceIndex] = j;
		else
			stackHeads[top++] = j;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			String[] outputs = new String[t];
			for(int i=0 ; i<t; i++) { 	
				int n = Integer.parseInt(br.readLine());
				stackHeads = new int[n];
				top = 0;
				String[] radii = br.readLine().split("\\s");;
				
				for (String j : radii) {
					compareAndPlace(Integer.parseInt(j));
				}
				String result = "";
				int stackCtr=0;
				if(top > 0) {
					for (int j=0; j<top; j++) {
						result+=(" "+stackHeads[j]);
					}
					result = top + result;
				}
				outputs[i] = result;
			}
			
			for (String output : outputs) {
				System.out.println(output);
			}
		
		} catch (Exception e) {
			return;
			
		}
	}
	

}
