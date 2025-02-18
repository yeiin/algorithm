import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[][] dp = new int[n][2];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }        

        int max = 0;

        for(int i=0; i<n; i++){
            if(dp[i][0] == 0){
                dp[i][0] = 1;
            }
            for(int j=i+1; j<n; j++){
                if(arr[i]<arr[j]){
                    dp[j][0] = Math.max(dp[i][0]+1, dp[j][0]);
                }

            }
        }


        for(int i=n-1; i>-1; i--){
            if(dp[i][1] == 0){
                dp[i][1] = 1;
            }
            for(int j=i-1; j>-1; j--){
                if(arr[i]<arr[j]){
                    dp[j][1] = Math.max(dp[i][1]+1, dp[j][1]);
                }
            }

           
        }


        for(int i=0; i<n; i++){
            max = Math.max(max, dp[i][0]+dp[i][1]-1);
        }

        System.out.println(max);
    
    }
}