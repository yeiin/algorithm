import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int[][] map = new int[board.length+1][board[0].length+1];

        for(int[] s: skill){
            int type = 1;
            if(s[0]==1) type = -1;
            
            map[s[1]][s[2]] += type * s[5];
            map[s[1]][s[4]+1] += -1 *type * s[5];
            map[s[3]+1][s[4]+1] += type * s[5];
            map[s[3]+1][s[2]] += -1 *type * s[5];
            
        }
        
        for(int i=0; i<map.length; i++){
            for(int j=1; j<map[i].length; j++){
                map[i][j] += map[i][j-1];
            }
        }
        
        
        for(int j=0; j<map[0].length; j++){
            for(int i=1; i<map.length; i++){
                map[i][j] += map[i-1][j];
            }
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if((map[i][j] + board[i][j])>=1) answer++;
            }
        }
        
        return answer;
    }
}