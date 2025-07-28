import java.util.*;

class Solution {
    boolean[][] pillar;
    boolean[][] beam;
    
    int n;
    public boolean checkBeam(int x, int y){
        if(y>=1 && pillar[x][y-1]
            || (x<n && y>=1 && pillar[x+1][y-1])
            || (x>=1 && x<n && beam[x-1][y] && beam[x+1][y])) return true;
        return false;
    } 
    
    public boolean checkPillar(int x, int y){
        if(y == 0 || (y>=1 && pillar[x][y-1]) 
            || beam[x][y] || (x>=1 && beam[x-1][y])) return true;
        
        return false;
    } 
    
    public void removePillar(int x, int y){  
        pillar[x][y] = false;
        
        if(y<n && pillar[x][y+1] && !checkPillar(x, y+1)){
            pillar[x][y] = true;
            return;
        }
        
        if(y<n && beam[x][y+1] && !checkBeam(x, y+1)){
            pillar[x][y] = true;
            return;
        }
        
        if(x>=1 && y<n && beam[x-1][y+1] && !checkBeam(x-1, y+1)){
            pillar[x][y] = true;
            return;
        }
             
    }
    
    public void addPillar(int x, int y){
        if(checkPillar(x, y)){
            pillar[x][y] = true;
        }        
    }
    
    public void removeBeam(int x, int y){
        beam[x][y] = false;
        
        if(pillar[x][y] && !checkPillar(x, y)){
            beam[x][y] = true;
            return;
        }
        
        if(x<n && pillar[x+1][y] && !checkPillar(x+1, y)){
            beam[x][y] = true;
            return;
        }
        
        if(x>=1 && beam[x-1][y] && !checkBeam(x-1, y)){
            beam[x][y] = true;
            return;
        }
        
        if(x<n && beam[x+1][y] && !checkBeam(x+1, y)){
            beam[x][y] = true;
            return;
        }
    }
    
    public void addBeam(int x, int y){
        if(checkBeam(x, y)){
            beam[x][y] = true;
        }
    }
    
    public int[][] solution(int n, int[][] build_frame) {
        this.n = n;
        List<int[]> answer = new ArrayList();
        
        pillar = new boolean[n+1][n+1];
        beam = new boolean[n+1][n+1];
        
        for(int[] build: build_frame){
            if(build[2]==0 && build[3]==0){
                removePillar(build[0], build[1]);
            }else if(build[2]==0 && build[3]==1){
                addPillar(build[0], build[1]);
            }else if(build[2]==1 && build[3]==0){
                removeBeam(build[0], build[1]);
            }else if(build[2]==1 && build[3]==1){
                addBeam(build[0], build[1]);
            }
        }
        
        for(int i=0; i<=n; i++){
            for(int j=0; j<=n; j++){
                if(pillar[i][j]) answer.add(new int[]{i, j, 0});
                if(beam[i][j]) answer.add(new int[]{i, j, 1});
            }
        }
        
        return answer.toArray(new int[answer.size()][]);
    }
}