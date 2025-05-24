import java.util.*;

class Solution {
    
    static int n;
    static int m;
    
    class Node{
        
        int redX;
        int redY;
        int blueX;
        int blueY;
        boolean[][] rVisited;
        boolean[][] bVisited;
        int count;
        
        public Node(int[] initNode, int count, boolean[][] rVisited, boolean[][] bVisited){
            this.redX = initNode[0];
            this.redY = initNode[1];
            this.blueX = initNode[2];
            this.blueY = initNode[3];
            this.rVisited = rVisited;
            this.bVisited = bVisited;
            this.count = count;
        }
    }
    
    public boolean isGoal(Node curr, Node goal){
        if(curr.redX == goal.redX && curr.redY == goal.redY && curr.blueX == goal.blueX && curr.blueY == goal.blueY){
            return true;
        }
        return false;
    }
    
    private boolean[][] deepCopy(boolean[][] original) {
        boolean[][] copy = new boolean[original.length][];
        for (int i = 0; i < original.length; i++) {
            copy[i] = original[i].clone();
        }
        return copy;
    }
    
    public int solution(int[][] maze) {
        n = maze.length;
        m = maze[0].length;
        int[] initNode = new int[4];
        int[] goalNode = new int[4];
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        int answer = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(maze[i][j]==1){
                    initNode[0] = i;
                    initNode[1] = j;
                }else if(maze[i][j]==2){
                    initNode[2] = i;
                    initNode[3] = j;
                }else if(maze[i][j]==3){
                    goalNode[0] = i;
                    goalNode[1] = j;
                }else if(maze[i][j]==4){
                    goalNode[2] = i;
                    goalNode[3] = j;
                }
            }
        }
        
        Queue<Node> mazeQ = new LinkedList();
        boolean[][] rVisited = new boolean[n][m];
        boolean[][] bVisited = new boolean[n][m];
        rVisited[initNode[0]][initNode[1]] = true;
        bVisited[initNode[2]][initNode[3]] = true;
        mazeQ.add(new Node(initNode, 0, rVisited, bVisited));
        
        Node goal = new Node(goalNode, 0, new boolean[n][m], new boolean[n][m]);
        
        while(!mazeQ.isEmpty()){
            Node curr = mazeQ.poll();            
            
            if(isGoal(curr, goal)){
                answer = curr.count;
                break;
            }
            
            for(int i=0; i<dx.length; i++){
                
                int nextRedX = curr.redX;
                int nextRedY = curr.redY;
                boolean rGoal = false;
                
                if(!(curr.redX == goal.redX && curr.redY == goal.redY)){
                        nextRedX += dx[i];
                        nextRedY += dy[i];
                }else{
                    rGoal = true;
                }
                
                if(nextRedX<0 || nextRedX>=n || nextRedY<0 || nextRedY>=m){
                        continue;
                }
                
                
                for(int j=0; j<dx.length; j++){
                    
                    int nextBlueX = curr.blueX;
                    int nextBlueY = curr.blueY;
                    boolean bGoal = false;
                    
                    if(!(curr.blueX == goal.blueX && curr.blueY == goal.blueY)){
                        nextBlueX += dx[j];
                        nextBlueY += dy[j];
                    }else{
                        bGoal = true;
                    }
                    
                    if(nextBlueX<0 || nextBlueX>=n || nextBlueY<0 || nextBlueY>=m){
                        continue;
                    }
                    
                    if(maze[nextRedX][nextRedY] == 5 || maze[nextBlueX][nextBlueY] == 5){
                        continue;
                    }
                    
                    if (nextRedX == nextBlueX && nextRedY == nextBlueY) {
                        continue;
                    }
                    
                    if(nextRedX == curr.blueX  && nextBlueX == curr.redX && nextRedY == curr.blueY && nextBlueY == curr.redY){
                        continue;
                    }
                    
                    
                
                    if((rGoal && !curr.bVisited[nextBlueX][nextBlueY])||(bGoal && !curr.rVisited[nextRedX][nextRedY]  )||(!curr.rVisited[nextRedX][nextRedY] && !curr.bVisited[nextBlueX][nextBlueY])){
                        boolean[][] newR = deepCopy(curr.rVisited);
                        boolean[][] newB = deepCopy(curr.bVisited);
                        newR[nextRedX][nextRedY] = true;
                        newB[nextBlueX][nextBlueY] = true;
                        mazeQ.add(new Node(new int[]{nextRedX, nextRedY, nextBlueX, nextBlueY}, curr.count+1, newR, newB));

                    }
                    
                }
            }
        }
        
        
        return answer;
        
        
    }
}