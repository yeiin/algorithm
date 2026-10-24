import java.util.*;

class Solution {
    
    int[] discounts = new int[]{10, 20, 30, 40};
    List<int[]> discounted = new ArrayList<>();
    int[] arr;
    
    public void dfs(int depth){
        
        if(depth == arr.length){
            discounted.add(arr.clone());
            return;
        }
        
        for(int i=0; i<discounts.length; i++){
            arr[depth] = discounts[i];
            dfs(depth+1);
        }
    }
    
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {0, 0};
        
        arr = emoticons.clone();
        
        //make discount 
        dfs(0);
        
        for(int[] d: discounted){ //discount 경우의 수 별로
            int plusCnt = 0;
            int maxCost = 0;
            for(int u=0; u<users.length; u++){ //사용자 별로 이 경우의 선택을 보면?
                int temp = 0;
                boolean isPlus = false;
                for(int i=0; i<d.length; i++){
                    if(d[i]>=users[u][0]){
                        temp += emoticons[i]* (100-d[i])/100;
                    }
                    
                    if(temp>=users[u][1]){
                        isPlus = true;
                        plusCnt++;
                        break;
                    }
                }
                
                if(!isPlus){
                    maxCost += temp;
                }
            }
                        
            if(answer[0]<plusCnt){
                answer[0] = plusCnt;
                answer[1] = maxCost;
            }else if(answer[0]==plusCnt && answer[1]<maxCost){
                answer[0] = plusCnt;
                answer[1] = maxCost;
            }
        }
        
        
        return answer;
    }
}