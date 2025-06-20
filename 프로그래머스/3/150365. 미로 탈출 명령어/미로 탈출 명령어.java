import java.util.*;

class Solution {
    
    int n;
    int m;
    int k;
    int r;
    int c;
    
    
    int[] dx = {1,0,0,-1};
    int[] dy = {0, -1, 1, 0};
    String[] directions = {"d","l","r","u"};
    String result = "";
    
    public boolean dfs(int x, int y, int depth, String answer){
        if(depth==k && x==r && y==c){
            this.result = answer;
            return true;
        }
        
        int remain = Math.abs(x-r)+Math.abs(y-c);
        
        if(remain + depth > k){
            result = "impossible";
            return false;
        }
        
        for(int i=0; i<dx.length; i++){
            
            int nextX = x+dx[i];
            int nextY = y+dy[i];
            
            if(nextX>=1 && nextX<=n && nextY >=1 && nextY<=m){
                if(dfs(nextX, nextY, depth+1, answer+directions[i])) return true;
            }
        }
        
        return false;
        
    }

    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {

        this.n = n;
        this.m = m;
        this.r = r;
        this.c = c;
        this.k = k;
        
        int remain = Math.abs(x-r)+Math.abs(y-c);

        if(remain > k || (k-remain)%2!=0){
            return "impossible";
        }
        
        dfs(x, y, 0, "");
        
        return result;      
    }
}