import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int t=0; t<time; t++ ){
            int n = Integer.parseInt(br.readLine());
            
            int[] arr = new int[n+1];
            st = new StringTokenizer(br.readLine());       
            for(int i=1; i<n+1; i++){
                if(i==1) arr[i] = Integer.parseInt(st.nextToken());
                else arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
            }            

            int[][] dp = new int[n+1][n+1];

            for(int k=1; k<n+1; k++){
                for(int from = 1; from+k<n+1; from++){
                    int to = from + k;
                    dp[from][to] = Integer.MAX_VALUE;
                    for(int mid = from; mid<to; mid++){
                        dp[from][to] = Math.min(dp[from][to], dp[from][mid] + dp[mid+1][to] + arr[to] - arr[from-1]); 
                    }
                }
            }
            
            System.out.println(dp[1][n]);

        }

        
    }
}