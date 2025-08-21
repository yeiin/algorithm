import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n][n];

        for(int i=0; i<n; i++){
            dp[i][i] = 1;
        }

        for(int i=0; i<n-1; i++){
            if(arr[i] == arr[i+1]) dp[i][i+1] = 1;
        }

        for(int i=2; i<n; i++){
            for(int j=0; j<n-i; j++){
                if(arr[j] == arr[j+i] && dp[j+1][j+i-1]==1) dp[j][j+i] = 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) -1;
            int b = Integer.parseInt(st.nextToken()) -1;

            if(sb.length()!=0) sb.append("\n");
            sb.append(dp[a][b]); 
            
        }

        System.out.println(sb.toString());
    }
}