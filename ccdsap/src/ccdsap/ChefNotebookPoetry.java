package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChefNotebookPoetry {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int t = Integer.parseInt(br.readLine());
			String output = "";
			for(int i=0; i<t; i++) {
				String[] input = br.readLine().split("\\s");
				int x = Integer.parseInt(input[0]);
				int y = Integer.parseInt(input[1]);	
				int k = Integer.parseInt(input[2]);
				int n = Integer.parseInt(input[3]);
				int pagesReq = x-y;
				String[] pagesAndCost = null;
				boolean possible = false;
				for(int j=0; j<n; j++) {
					pagesAndCost = br.readLine().split("\\s");
					int pages = Integer.parseInt(pagesAndCost[0]);
					int cost = Integer.parseInt(pagesAndCost[1]);
					
					if(pages>=pagesReq && cost<= k) {
						possible = true;
						break;
					}
					
				}
				if(possible)
					output+=("LuckyChef"+(i==t-1? "":"\n"));
				else
					output+=("UnluckyChef"+(i==t-1? "":"\n"));
					
			}
			System.out.print(output);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return;
		}
	}

}
