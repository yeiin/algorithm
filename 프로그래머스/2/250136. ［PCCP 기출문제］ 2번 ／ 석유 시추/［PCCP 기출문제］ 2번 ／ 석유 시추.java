import java.util.*;

class Solution {
    public int solution(int[][] land) {
        int answer = 0;
        
        int n = land.length;
        int m = land[0].length;
        int[][] visited = new int[n][m];
        
        int landNum = 1;
        int[] landCount = new int[n*m+1];
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j] == 0 && land[i][j] == 1){
                    Queue<int[]> q = new LinkedList();
                    q.add(new int[] {i,j});
                    visited[i][j] = landNum;
                    landCount[landNum] +=1;

                    while(!q.isEmpty()){
                        int[] curr = q.poll();
                        
                        for(int k=0; k<4; k++){
                            int nextX = curr[0] + dx[k];
                            int nextY = curr[1] + dy[k];
                            
                            if(nextX>=0 && nextX<n && nextY>=0 && nextY<m){
                                if(visited[nextX][nextY] == 0 && land[nextX][nextY] == 1){
                                    q.add(new int[]{nextX, nextY});
                                    visited[nextX][nextY] = landNum;
                                    landCount[landNum] +=1;
                                }
                            }
                        }
                        
                    }
                    
                    landNum++;   
                }
            }
        }
  
        for(int i=0; i<m; i++){
            int temp = 0;
            Set<Integer> landSet = new HashSet();
            for(int j=0; j<n; j++){
                landSet.add(visited[j][i]);
            }
            
            Iterator<Integer> iterSet = landSet.iterator();
            while(iterSet.hasNext()){
                temp += landCount[iterSet.next()];
            }            
            answer = Math.max(answer,temp);
        }
        
        return answer;
    }
}