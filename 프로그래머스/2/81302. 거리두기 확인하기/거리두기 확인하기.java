import java.util.*;

class Solution {
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for(int i=0; i<places.length; i++){
            String[] place = places[i];
            
            boolean[][] visited = new boolean[5][5];
            char[][] seats = new char[place.length][5];
            for(int j=0; j<place.length; j++){
                seats[j] = place[j].toCharArray();
            }
            
            Queue<int[]> q = new LinkedList();
            
            boolean flag = false;
            for(int x=0; x<seats[0].length; x++){
                for(int y=0; y<seats.length; y++){
                    if(seats[x][y]=='P'){
                        if(visited[x][y]){
                            flag = true;
                            break;
                        }
                        
                        q.clear();
                        q.add(new int[]{x, y, 0});
                        visited[x][y] = true;
                        
                        while(!q.isEmpty()){
                            int[] curr = q.poll();
                            
                            if(curr[2]>=2) continue;
                            
                            for(int k=0; k<dx.length; k++){
                                int nextX = curr[0] + dx[k];
                                int nextY = curr[1] + dy[k];
                                
                                if(nextX<0 || nextX>=seats.length || nextY<0 || nextY>=seats[0].length) continue;
                                if(visited[nextX][nextY]) continue;
                                if(seats[nextX][nextY]=='X') continue;
                                if(seats[nextX][nextY]=='P'){
                                    flag = true;
                                    break;
                                }
                                visited[nextX][nextY] = true;
                                q.add(new int[]{nextX, nextY, curr[2]+1});
                            }
                        }
                    }
                   
                }
                

                if(flag) break;
            }
            
            
            if(!flag) answer[i] = 1;
        }
        
        return answer;
    }
}