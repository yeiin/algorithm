import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] dp = new int[k+1];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());         

            for(int w=k; w>=weight; w--){
                dp[w] = Math.max(dp[w], dp[w - weight] + value);
            }
        }
        
        System.out.println(dp[k]);

    }
}