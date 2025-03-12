import java.util.*;
import java.io.*;


public class Main{

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] dp = new int[31];
        
        dp[0] = 1;
        dp[2] = 3;

        if(n%2==1){
            System.out.println(0);
        }else{
            for(int i=4; i<=n; i+=2){
                dp[i] = dp[i-2] * dp[2];

                for(int j=i-4; j>=0; j -=2){
                    dp[i] += dp[j]*2;
                }
            }
            System.out.println(dp[n]);
        }


    }
}