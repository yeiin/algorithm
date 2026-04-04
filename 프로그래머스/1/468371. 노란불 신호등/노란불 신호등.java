import java.util.*;

class Solution {
    public int solution(int[][] signals) {
        int answer = -1;
        int maxRange = 1;
        
        for(int[] s: signals){
            maxRange *= (s[0]+s[1]+s[2]);
        }
        
        int[][] arr = new int[signals.length][maxRange+1];
        for(int i=0; i<signals.length; i++){
            int sIdx = 0;
            int cnt = 0;
            
            for(int j=1; j<maxRange+1; j++){
                arr[i][j] = sIdx;
                cnt++;
                if(cnt == signals[i][sIdx]){
                    sIdx = (sIdx+1)%3;
                    cnt=0;
                }
            }            
        }
        
        for(int i=1; i<maxRange+1; i++){
            
            boolean flag = true;
            for(int j=0; j<signals.length; j++){
                if(arr[j][i]!=1){
                    flag = false;
                    break;
                }
            }            
            if(flag){
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}