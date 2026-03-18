import java.util.*;

class Solution {
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j]){
                    visited[i][j] = true;
                    if(picture[i][j]!=0){
                        numberOfArea++;                      
                        
                        int color = picture[i][j];

                        int num = 1;
                        
                        Queue<int[]> q = new LinkedList();
                        q.add(new int[]{i, j});
                        
                        while(!q.isEmpty()){
                            int[] curr = q.poll();
                            
                            for(int x=0; x<dx.length; x++){
                                int nextX = curr[0] + dx[x];
                                int nextY = curr[1] + dy[x];
                                                                
                                if(nextX<0 || nextX>=m || nextY<0 || nextY>=n) continue;
                                if(visited[nextX][nextY]) continue;
                                if(picture[nextX][nextY] != color) continue;
                                
                                visited[nextX][nextY] = true;
                                q.add(new int[]{nextX, nextY});
                                num++;
                            }
                           
                        }
                        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, num);                        
                    }
                }
            }
        }
        
        
        
        
        
        
        
        
        
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}