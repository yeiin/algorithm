import java.io.*;
import java.util.*;

class Main{

    static int answer = 0;

    static int n;
    static String[][] board;
    static int[][] color;

    static int[] dx = {-1, -1, 0, 0, 1, 1};
    static int[] dy = {0, 1, -1, 1, -1, 0};

    public static void dfs(int x, int y, int paint){

        color[x][y] = paint;
        if(answer == 0) answer = 1;

        for(int i=0; i<dx.length; i++){
            int roundX = x + dx[i];
            int roundY = y + dy[i];

            if(roundX<0 || roundX>=n || roundY <0 || roundY>=n) continue;
            if(!board[roundX][roundY].equals("X")) continue;

            if(answer<2) answer = 2;

            if(color[roundX][roundY]==paint){
                answer = 3;
                return;
            }

            if(color[roundX][roundY]!=-1) continue;
            
            if(paint==1){
                dfs(roundX, roundY, 0);
            }else{
                dfs(roundX, roundY, 1);
            }
            
        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new String[n][n];
        color = new int[n][n];

        for(int i=0; i<n; i++){
            board[i] = br.readLine().split("");
            Arrays.fill(color[i], -1);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(board[i][j].equals("X") && color[i][j] == -1){
                    dfs(i, j, 0);
                }
            }
        }
        
        System.out.println(answer);
    }
}