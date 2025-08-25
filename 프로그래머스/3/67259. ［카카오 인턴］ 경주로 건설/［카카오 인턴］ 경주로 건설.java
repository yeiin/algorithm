import java.util.*;

class Solution {
    
    class Node{
        int x;
        int y;
        int dir;
        int cost;
        
        public Node(int x, int y, int dir, int cost){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
    
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        
        int n = board.length;
        int[][][] visited = new int[n][n][2];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++)
               Arrays.fill(visited[i][j], Integer.MAX_VALUE);
        }
        
        Queue<Node> q = new LinkedList();
        q.add(new Node(0, 0, -1, 0));
        visited[0][0][0] = 0;
        visited[0][0][1] = 0;
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            
            if(curr.x == n-1 && curr.y == n-1){
                answer = Math.min(answer, curr.cost);
                continue;
            }
            
            for(int d = 0; d<dx.length; d++){
                int nextX = curr.x + dx[d];
                int nextY = curr.y + dy[d];
                
                if(nextX<0||nextX>=n||nextY<0||nextY>=n) continue;              
                if(board[nextX][nextY]==1) continue;
                
                int nextCost = curr.cost+100;
                if(curr.dir!=-1 && (d%2)!=curr.dir){
                    nextCost+=500;
                }
                
                if(visited[nextX][nextY][d%2]<nextCost) continue;                
                visited[nextX][nextY][d%2] = nextCost;
                
                q.add(new Node(nextX, nextY, d%2, nextCost));
                
            }
        }
        
 
        return answer;
    }
}