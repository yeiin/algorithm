import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int[] time = new int[number];
        int[] price = new int[number];
        int[] dp = new int[number+1];

        for(int i=0; i<number; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            price[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<number; i++){
           
            if(i+time[i]<=number){
                dp[i+time[i]] = Math.max(dp[i+time[i]], dp[i]+price[i]);
            }
            dp[i+1] = Math.max(dp[i], dp[i+1]);
            
        }
        System.out.println(dp[number]);
    }
}