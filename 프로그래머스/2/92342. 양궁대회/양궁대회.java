import java.util.*;

class Solution {
    
    int maxScore = 0;
    
    int[] apeachInfo;
    int[] ryanInfo = {-1};
    
    public int getScore(int[] ryan){
        int[] result = {0,0};
            
        for(int i=0; i<ryan.length; i++){
            if(ryan[i]>apeachInfo[i]){
                result[1] += (10-i);
            }else if(apeachInfo[i]!=0){
                result[0] += (10-i);
            }
        }
        
        return result[1] - result[0];
    }
        
    public void dfs(int depth, int arrowCnt, int[] ryan){
                
        if(arrowCnt == 0 || depth >= ryan.length-1){
            ryan[depth] = arrowCnt;
            
            int newScore = getScore(ryan);
            
            if(newScore<0) return;

            if(maxScore<newScore){     
                maxScore = newScore;
                ryanInfo = ryan.clone();
            }else if(maxScore == newScore){
                boolean flag = false;
                
                if(ryanInfo.length != 1){
                    for(int i= ryan.length-1; i>=0; i--){
                        if(ryan[i] == 0 && ryanInfo[i] == 0) continue;
                        if(ryan[i] > ryanInfo[i]){
                            flag = true;
                        }
                        break;
                    }
                }
                
                if(flag){
                    maxScore = newScore;
                    ryanInfo = ryan.clone();
                }
            }  
            
            return;
        }
                
        int a = apeachInfo[depth]+1;   
        
        if(arrowCnt-a>=0){
            int[] next = ryan.clone();
            next[depth] = a;
            dfs(depth+1, arrowCnt-a, next);
        }
        
        dfs(depth+1, arrowCnt, ryan.clone());
        
    }
    
    
    public int[] solution(int n, int[] info) {
        apeachInfo = info;
        dfs(0, n, new int[info.length]);
        
        return ryanInfo;
    }
}