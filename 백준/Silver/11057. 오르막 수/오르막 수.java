import java.util.Arrays;
import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int number = sc.nextInt();
        long[][] dp = new long[number][10];
        Arrays.fill(dp[0], 1);

        for(int i = 1; i<number; i++){
            for(int j=0; j<10; j++){
                for(int k=j; k<10; k++){
                    dp[i][j] += dp[i-1][k];
                }
                dp[i][j] = dp[i][j] % 10007;
            }
        }

        long answer = 0;
        for(int i=0; i<10; i++){
            answer += dp[number-1][i];
        }

        System.out.println(answer% 10007);

        sc.close();

    }
}