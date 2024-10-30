import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        int number = sc.nextInt();

        int[] price = new int[number+1];
        int[] dp = new int[number+1];
        Arrays.fill(dp, 10000);
        dp[0] = 0;

        for(int i=1; i<=number; i++){
            price[i] = sc.nextInt();
        }

        for(int i=1; i<=number; i++){
            for(int j=1; j<=i; j++){
                dp[i] = Math.min(dp[i], price[j]+dp[i-j]);
            }
        }
        System.out.println(dp[number]);
    }
}