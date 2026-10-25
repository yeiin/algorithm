class Solution {
    public int solution(int n, int[] tops) {
        int answer = 0;
        
        int[] rightDp = new int[n];
        int[] dp = new int[n];
        
        rightDp[0] = 1;
        dp[0] = 2;
        if(tops[0]==1) dp[0]++;
        
        for(int i=1; i<n; i++){
            rightDp[i] = rightDp[i-1] % 10007 + dp[i-1] % 10007;
            if(tops[i]==1){
                dp[i] = 3*dp[i-1]%10007 + 2*rightDp[i-1]%10007;
            }else{
                dp[i] = 2*dp[i-1]%10007 + rightDp[i-1]%10007;
            }
        }
        
        answer = (dp[n-1] + rightDp[n-1])%10007;
        
        return answer;
    }
}