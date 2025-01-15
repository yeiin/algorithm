import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int [][] dp = new int[2][n];
        

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());  
        }

        dp[0][0] = arr[0];
        dp[1][0] = 0;
        int max = arr[0];
        
        for(int j=1; j<n; j++){
            dp[0][j] = Math.max(dp[0][j-1]+arr[j], arr[j]);
            dp[1][j] = Math.max(dp[1][j-1]+arr[j], dp[0][j-1]);

            max = Math.max(max,  Math.max(dp[0][j], dp[1][j]));
        }

        
        System.out.println(max);

    }
}