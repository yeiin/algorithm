import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        sc.close();
        int[] dp = new int[number+1];
        Arrays.fill(dp, 100000);

        for(int i=1; i<=number; i++){

            for(int j = 1; j*j<=i; j++){
                if(j*j == i){
                    dp[i] = 1;
                }else{
                    dp[i] = Math.min(dp[i],dp[i-(j*j)] + dp[j*j]);
                }
                
            }
        }
        System.out.println(dp[number]);

    }
}