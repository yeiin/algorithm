import java.util.*;
import java.io.*;
public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        int[] dp = new int[n+1];
        StringTokenizer st;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++){
            if(i+arr[i][0]<=n){
                dp[i+arr[i][0]] = Math.max(dp[i+arr[i][0]], dp[i]+arr[i][1]);
            }

            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        System.out.println(dp[n]);
    }
}