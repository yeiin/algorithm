import java.util.*;

class Solution {
    
    public String toK(int n, int k){
        String result = "";
        
        while(n>0){
            String temp = Integer.toString(n%k);
            n /= k;
            result = temp + result;
        }
        
        return result;
    }
    
    
    public int solution(int n, int k) {
        int answer = 0;        
        
        String[] arr = toK(n, k).split("0");
        
        for(String a: arr){
            if(a.trim().isEmpty()) continue;
            
            long temp = Long.parseLong(a);
            
            if(temp<2) continue;
            boolean isPrime = true;
            for(long i=2; i*i<=temp; i++){
                if(temp%i==0) {
                    isPrime = false;
                    break;
                }
            }
            
            if(isPrime) answer++;
            
        }
        return answer;
    }
}