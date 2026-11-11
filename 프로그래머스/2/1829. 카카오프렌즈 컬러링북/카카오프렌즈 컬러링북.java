import java.util.*;

class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        int[] answer = new int[2];
        
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        //picture pixel brute force 
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j]!=0 && !visited[i][j]){
                    q.clear();
                    q.add(new int[]{i, j});
                    int area = picture[i][j];
                    int sizeOfArea = 1;
                    visited[i][j] = true;
                    
                    //bfs
                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        
                        for(int k=0; k<dx.length; k++){
                            int nx = curr[0] + dx[k];
                            int ny = curr[1] + dy[k];
                            
                            if(nx<0 || nx>=m || ny <0 || ny>=n || visited[nx][ny]) continue;
                            if(picture[nx][ny] != area) continue;
                            
                            //next 
                            q.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                            sizeOfArea++;
                        }
                    }
                    
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sizeOfArea);
                    
                }
            }
        }
        
        
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}