import java.util.*;

class Solution {
    
    public int solution(int n, int[] tops) {
        
        int answer = 0 ;
        
        int[] leftDp = new int[n];
        int[] dp = new int[n];
        
        leftDp[0] = 1;
        dp[0] = 2;
        
        if(tops[0]==1){
            dp[0]++;
        }
        
        
        for(int i=1; i<n; i++){
            leftDp[i] = (leftDp[i-1] + dp[i-1]) % 10007;
            if (tops[i] == 1) {
                dp[i] = (leftDp[i-1] * 2 + dp[i-1] * 3) % 10007;
            } else {
                dp[i] = (leftDp[i-1] + dp[i-1] * 2) % 10007;
            }
            
        }
       
        
        return (leftDp[n-1] + dp[n-1]) % 10007;
        
    }
}