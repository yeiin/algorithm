import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] table = new int[board.length+1][board[0].length+1];
        
        for(int[] s: skill){
            if(s[0]==1){
                table[s[1]][s[2]] -= s[5];
                table[s[1]][s[4]+1] += s[5];
                table[s[3]+1][s[2]] += s[5];
                table[s[3]+1][s[4]+1] -= s[5];
            }else{
                table[s[1]][s[2]] += s[5];
                table[s[1]][s[4]+1] -= s[5];
                table[s[3]+1][s[2]] -= s[5];
                table[s[3]+1][s[4]+1] += s[5];
            } 
        }
        
        for(int i=0; i<table.length; i++){
            for(int j=1; j<table[0].length; j++){
                table[i][j] += table[i][j-1];
            }
        }
        
        for(int j=0; j<table[0].length; j++){
            for(int i=1; i<table.length; i++){
                table[i][j] += table[i-1][j];
            }
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                board[i][j] += table[i][j];
                if(board[i][j]>=1) answer++;
            }
        }
                
        return answer;
    }
}