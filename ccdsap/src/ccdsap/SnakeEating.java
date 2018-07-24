package ccdsap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
 
/**
 *
 * @author Parth
 */
class SnakeEating {
    
    public static void main(String[] args){
        InputReader in = new InputReader();
        PrintWriter out = new PrintWriter(System.out);
        
        int test = in.nextInt();
        while(test-->0){
            int snakes = in.nextInt();
            int query = in.nextInt();
            
            Long arr[] = new Long[snakes];
            for(int i=0; i<snakes; i++){
                arr[i] = in.nextLong();
            }
            Arrays.sort(arr);
            long max = arr[snakes-1] + snakes-1;
            HashMap<Long, Integer>map = new HashMap<>();
            
            while(query-->0){
                long len = in.nextInt();
                if(len>max){
                    out.println("0");
                    continue;
                }
                
                if(map.containsKey(len)){
                    out.println(map.get(len));
                    continue;
                }
                
                int p1 = 0;
                int p2 = Arrays.binarySearch(arr, len);
                int ans = 0;
                
                if(p2<0){
                    p2 = -p2-2;
                }else{
                    p2-=1;
                }
                //System.out.println("p2: "+p2+" len: "+len);
                ans += snakes-p2-1;
                
                for(int i=p2; i>=p1; i--){
                    if(len-arr[i]<=(i-p1)){
                        ans++;
                        p1 += (int) len-arr[i];
                    }
                    else break;
                }
                /*while(p2>p1 && ans<snakes){
                    p1 += (int) len-arr[p2];
                    if(p1<=p2){
                        ans++;
                        p2--;
                    }
                }*/
                map.put(len, ans);
                out.println(ans);
            }
        }
        
        out.close();
    }
    
    static class InputReader {
 
        BufferedReader br;
        StringTokenizer st;
 
        public InputReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        long nextLong() {
            return Long.parseLong(next());
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
} 