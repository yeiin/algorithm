import java.util.*;

class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        
        int[][] board = new int[rows][columns];
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<columns; j++){
                board[i][j] = columns * i + j +1;
            }
        }
        
        for(int i=0; i<queries.length; i++){
            int[] query = queries[i];
            
            int x1 = query[0]-1;
            int y1 = query[1]-1;
            int x2 = query[2]-1;
            int y2 = query[3]-1;
            
            int start = board[x1][y1];
            int min = start;
            
            for(int x=x1+1; x<x2+1; x++){
                board[x-1][y1] = board[x][y1];
                min = Math.min(min, board[x-1][y1]);
            }
            
            for(int y=y1+1; y<y2+1; y++){
                board[x2][y-1] = board[x2][y];
                min = Math.min(min, board[x2][y-1]);
            }
            
            for(int x=x2-1; x>x1-1; x--){
                board[x+1][y2] = board[x][y2];
                min = Math.min(min, board[x+1][y2]);
            }
            
            for(int y=y2-1; y>y1; y--){
                board[x1][y+1] = board[x1][y];
                min = Math.min(min, board[x1][y+1]);
            }
            
            board[x1][y1+1] = start;
            answer[i] = min;            
        }
        
        
        return answer;
    }
}