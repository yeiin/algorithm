import java.util.*;

class Solution {     
    int answer = Integer.MAX_VALUE;
    
    int n;
    int[] weak;
    int[] dist;
    
    boolean[] fVisited;
    
    public void dfs(int idx, int fNum, boolean[] visited){  
        if (fNum >= answer || fNum > weak.length) return;
        if(idx==weak.length){   
            boolean flag = true;
            for(int w: weak){
                if(!visited[w]) return;
            }              
            answer = Math.min(answer, fNum);              
            return;
        }
        
        int wIdx = weak[idx];     
        
        
        if(!visited[wIdx]){
            for(int i=fVisited.length-1; i>=0; i--){
                if(fNum+1>=answer) return;
                if(!fVisited[i]){
                                        
                    boolean flag = true;                
                    for(int j=0; j<=dist[i]; j++){
                        if(visited[(wIdx+j)%n]){
                            flag = false;
                            break;
                        }
                    }
                    
                    if(flag){
                        fVisited[i] = true;
                        boolean[] nVisited = visited.clone();
                        for(int j=0; j<=dist[i]; j++){
                            nVisited[(wIdx+j)%n] = true;
                        }
                        dfs(idx+1, fNum+1, nVisited);     
                        fVisited[i] = false;
                    }
                   
                }
            }            
        }else{
            dfs(idx+1, fNum, visited);
        }
    }
    
    public int solution(int n, int[] weak, int[] dist) {      
        this.n = n;
        this.weak = weak;
        Arrays.sort(dist);
        this.dist = dist;
       
        fVisited = new boolean[dist.length];
        
        for(int i=0; i<weak.length; i++)
            dfs(i, 0, new boolean[n]);
        
        if(answer==Integer.MAX_VALUE) answer = -1;        
        return answer;
    }
}