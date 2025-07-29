import java.util.*;

class Solution {
    
    public int[][] rotate(int[][] r){
        int m = r.length;
        int[][] result = new int[m][m];        
        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++) result[j][m-1-i] = r[i][j];
        }
        return result;
    }

    public boolean solution(int[][] key, int[][] lock) {        
        int n = lock.length;
        int m = key.length;
        int lhole = 0;
        
        int[][] elock = new int[2*m+n-2][2*m+n-2];
        
        for(int i=0; i<elock.length; i++)
            Arrays.fill(elock[i], 2);
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                elock[m-1+i][m-1+j] = lock[i][j];
                if(lock[i][j] == 0) lhole++;
                
            }
        }
        
        for(int r=0; r<4; r++){       
            for(int x=0; x<m+n-1; x++){
                for(int y=0; y<m+n-1; y++){
                    
                    boolean isMatch = true;
                    int matchNum = 0;
                                    
                    for(int lx=0; lx<m; lx++){
                        for(int ly=0; ly<m; ly++){
                            if(key[lx][ly]==1 && elock[x+lx][y+ly]==0){
                                matchNum++;
                            }
                            
                            if((key[lx][ly]==1 && elock[x+lx][y+ly]==1) || (key[lx][ly]==0 && elock[x+lx][y+ly]==0)){
                                isMatch = false;
                                break;
                            }
                        }
                        if(!isMatch) break;
                        
                    }
                    
                    if(isMatch && matchNum == lhole) return true;             
                }
            }
            
            key = rotate(key);
        }
        
        return false;
    }
}