import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int[] answer = new int[2];
        
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new ArrayDeque<>();
        
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){            
                if(visited[i][j]) continue;
                
                q.add(new int[]{i, j});
                visited[i][j]=true;
                
                int c = picture[i][j];
                int count = 1;
                
                while(!q.isEmpty()){
                    int[] curr = q.poll();
                    
                    for(int x=0; x<4; x++){
                        int nX = curr[0]+dx[x];
                        int nY = curr[1]+dy[x];
                        
                        if(nX>=0 && nX<m && nY>=0 && nY<n){
                            if(!visited[nX][nY] && picture[nX][nY]==c){
                                q.add(new int[]{nX, nY});
                                visited[nX][nY]=true;
                                count ++;
                            }
                        }
                    }
                    
                }
                
                if(c==0) continue;
                numberOfArea++;
                maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
                
            }
        }
        
        
        
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}