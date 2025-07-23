import java.util.*;

class Solution {    
    int n;
    
    boolean[][][] visited;
    int[][] board;
    
    Queue<int[]> q = new LinkedList();
    
    public void basicMove(int[] curr){
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for(int i=0; i<dx.length; i++){
            int leftX = curr[0] + dx[i];
            int leftY = curr[1] + dy[i];
            int rightX = curr[2] + dx[i];
            int rightY = curr[3] + dy[i];

            if(leftX<0 || leftX>=n || rightX<0 || rightX>=n) continue;
            if(leftY<0 || leftY>=n || rightY<0 || rightY>=n) continue;
            if(board[leftX][leftY]==1 || board[rightX][rightY]==1) continue;

            if(!visited[leftX][leftY][curr[4]]){
                visited[leftX][leftY][curr[4]] = true;
                q.add(new int[]{leftX, leftY, rightX, rightY, curr[4], curr[5]+1});
            }
        }
    }
    
    public void changeDir(int[] curr){
        if(curr[4]==0){
            if((curr[0]+1)<n && (curr[2]+1<n) && board[curr[0]+1][curr[1]]!=1 && board[curr[2]+1][curr[3]]!=1){                
                if(!visited[curr[2]][curr[3]][1]){
                    visited[curr[2]][curr[3]][1] = true;
                    q.add(new int[]{curr[2], curr[3], curr[2]+1, curr[3], 1, curr[5]+1});
                }
                
                if(!visited[curr[0]][curr[1]][1]){
                    visited[curr[0]][curr[1]][1] = true;
                    q.add(new int[]{curr[0], curr[1], curr[0]+1, curr[1], 1, curr[5]+1});
                }               
            }
            
            if((curr[0]-1)>=0 && (curr[2]-1>=0) && board[curr[0]-1][curr[1]]!=1 && board[curr[2]-1][curr[3]]!=1){               
                if(!visited[curr[2]-1][curr[3]][1]){
                    visited[curr[2]-1][curr[3]][1] = true;
                    q.add(new int[]{curr[2]-1, curr[3], curr[2], curr[3], 1, curr[5]+1});
                }
                
                if(!visited[curr[0]-1][curr[1]][1]){
                    visited[curr[0]-1][curr[1]][1] = true;
                    q.add(new int[]{curr[0]-1, curr[1], curr[0], curr[1], 1, curr[5]+1});
                }                
            }           
        }else{
            if((curr[1]+1)<n && (curr[3]+1)<n && board[curr[0]][curr[1]+1]!=1 && board[curr[2]][curr[3]+1]!=1){
                if(!visited[curr[0]][curr[1]][0]){
                    visited[curr[0]][curr[1]][0] = true;
                    q.add(new int[]{curr[0], curr[1], curr[0], curr[1]+1, 0, curr[5]+1});
                }       
                if(!visited[curr[2]][curr[3]][0]){
                    visited[curr[2]][curr[3]][0] = true;
                    q.add(new int[]{curr[2], curr[3], curr[2], curr[3]+1, 0, curr[5]+1});
                }
            }   
            
            if(curr[1]-1>=0 && curr[3]-1>=0 && board[curr[0]][curr[1]-1]!=1 && board[curr[2]][curr[3]-1]!=1){
                if(!visited[curr[2]][curr[3]-1][0]){
                    visited[curr[2]][curr[3]-1][0] = true;
                    q.add(new int[]{curr[2], curr[3]-1, curr[2], curr[3], 0, curr[5]+1});
                } 
                
                if(!visited[curr[0]][curr[1]-1][0]){
                    visited[curr[0]][curr[1]-1][0] = true;
                    q.add(new int[]{curr[0], curr[1]-1, curr[0], curr[1], 0, curr[5]+1});
                }
            }
        }
    }
    
    public int solution(int[][] board) {
        int answer = 0;
        this.board = board;
        
        n = board.length;
        visited = new boolean[n][n][2];
        
        q.add(new int[]{0, 0, 0, 1, 0, 0});
        visited[0][0][0] = true;
        
        while(!q.isEmpty()){
            int[] curr = q.poll();
            
            if(curr[2] == n-1 && curr[3] == n-1){
                answer = curr[5];
                break;
            }
                   
            basicMove(curr);
            changeDir(curr);            
        }
        
        return answer;
    }
}