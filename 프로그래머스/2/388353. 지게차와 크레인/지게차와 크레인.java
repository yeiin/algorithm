import java.util.*;

class Solution {
    int n;
    int m;
    
    public boolean isMargin(int i, int j){
        if(i==0 || i==this.n-1){
            return true;
        }
        
        if(j==0 || j==this.m-1){
            return true;
        }
        
        return false;
    }
    public boolean pointValidation(int i, int j){
        if(i>=0 && i<this.n && j>=0 && j<this.m){
            return true;
        }
        return false;
    }
    
    public int solution(String[] storage, String[] requests) {
        
        this.n = storage.length;
        this.m = storage[0].length();
        
        int answer = n*m;
        
        Queue<int[]> q = new LinkedList();
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        String[][] map = new String[n][m];
        boolean[][] visited = new boolean[n][m];
        boolean[][] routes = new boolean[n][m];
        
        for(int i=0; i<n; i++){
            map[i] = storage[i].split("");
        }
        
        for(String request: requests){      
            if(request.length() == 1){
                for(int i=0; i<n; i++){
                    for(int j=0; j<m; j++){
                         if(map[i][j].equals(request) && !visited[i][j] && (routes[i][j] || isMargin(i, j))){
                            visited[i][j] = true;
                            answer--;
                            q.add(new int[]{i, j});
                        }
                    }
                }
                
                while(!q.isEmpty()){
                    int[] curr = q.poll();
                    routes[curr[0]][curr[1]] = true;
                    
                    for(int k=0; k<dx.length; k++){
                        int nextI = curr[0] + dx[k];
                        int nextJ = curr[1] + dy[k];
                        
                        if(pointValidation(nextI,nextJ)){
                            if(visited[nextI][nextJ] && !routes[nextI][nextJ]) {
                                q.add(new int[] {nextI,nextJ});
                            }
                            routes[nextI][nextJ] = true;   
                        } 
                    }
                }
                
                
            }else{
                for(int i=0; i<n; i++){
                    for(int j=0; j<m; j++){
                        if(request.contains(map[i][j]) && !visited[i][j]){
                            visited[i][j] = true;
                            answer--;
                            
                            if(isMargin(i, j)){
                                routes[i][j] = true;
                                q.add(new int[]{i, j});
                            }else if(routes[i][j]){
                                q.add(new int[]{i, j});
                            }
                        }
                    }
                }
                
                
                while(!q.isEmpty()){
                    int[] curr = q.poll();
                    routes[curr[0]][curr[1]] = true;
                    
                    for(int k=0; k<dx.length; k++){
                        int nextI = curr[0] + dx[k];
                        int nextJ = curr[1] + dy[k];
                        
                        if(pointValidation(nextI,nextJ)){
                            if(visited[nextI][nextJ] && !routes[nextI][nextJ]) {
                                q.add(new int[] {nextI,nextJ});
                            }
                            routes[nextI][nextJ] = true;   
                        } 
                    }
                }
            }
           
        }
        
        return answer;
    }
}