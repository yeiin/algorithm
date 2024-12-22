import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int number = Integer.parseInt(st.nextToken());
        int[][] rgb = new int[number][3];
        int[][] dp = new int[number][3];

        for(int i=0; i<number; i++){
            st = new StringTokenizer(br.readLine());
            rgb[i][0] = Integer.parseInt(st.nextToken());
            rgb[i][1] = Integer.parseInt(st.nextToken());
            rgb[i][2] = Integer.parseInt(st.nextToken());
        }

        dp[0][0] = rgb[0][0];
        dp[0][1] = rgb[0][1];
        dp[0][2] = rgb[0][2];

        for(int i=1; i<number; i++){
            dp[i][0] = Math.min(dp[i-1][1]+rgb[i][0],dp[i-1][2]+rgb[i][0]);
            dp[i][1] = Math.min(dp[i-1][0]+rgb[i][1],dp[i-1][2]+rgb[i][1]);
            dp[i][2] = Math.min(dp[i-1][0]+rgb[i][2],dp[i-1][1]+rgb[i][2]);
        }

        int min = Math.min(dp[number-1][0], dp[number-1][1]);
        System.out.println(Math.min(min, dp[number-1][2]));
    }
}