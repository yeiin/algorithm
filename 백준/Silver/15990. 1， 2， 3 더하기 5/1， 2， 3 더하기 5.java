import java.util.*;


public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        long[][] dp = new long[100000][3];

        dp[0] = new long[]{1,0,0};
        dp[1] = new long[]{0,1,0};
        dp[2] = new long[]{1,1,1};

        for(int i = 3; i<100000; i++){
            dp[i][0] = (dp[i-1][1]+dp[i-1][2])%1000000009;
            dp[i][1] = (dp[i-2][0]+dp[i-2][2])%1000000009;
            dp[i][2] = (dp[i-3][0]+dp[i-3][1])%1000000009;

        }

        for(int t=0; t<T; t++){
            int number = sc.nextInt();
            long sum = dp[number-1][0]+dp[number-1][1]+dp[number-1][2];
            System.out.println(sum%1000000009);

        }
        sc.close();
        
    }
}