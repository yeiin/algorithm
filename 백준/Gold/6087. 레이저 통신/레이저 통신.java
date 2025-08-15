import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        char[][] board = new char[h][w];
        int[][][] visited = new int[h][w][dx.length];

        int[] start = new int[]{-1, -1};
        int[] end = new int[]{-1, -1};

        for(int i=0; i<h; i++){
            board[i] = br.readLine().toCharArray();
            for(int j=0; j<w; j++){
                if(board[i][j]=='C'){
                    if(start[0] == -1){
                        start = new int[]{i, j};
                    }else{
                        end = new int[]{i, j};
                    }
                }
            }
        }

        for(int[][] arr: visited){
            for(int[] a: arr){
                Arrays.fill(a, Integer.MAX_VALUE);
            }
        }
            
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<dx.length; i++){ 
            q.add(new int[]{start[0], start[1], i, 0});
            visited[start[0]][start[1]][i] = 0;   
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();

            for(int j=curr[2]; j<dx.length+curr[2]; j++){
                if(j==curr[2]+2) continue;

                int dir = j%dx.length;

                int nextX = curr[0] + dx[dir];
                int nextY = curr[1] + dy[dir];

                if(nextX<0 || nextX>=h || nextY<0 || nextY>=w) continue;
                if(board[nextX][nextY]=='*') continue;

                int next = curr[3];
                if(dir!=curr[2]) next++;

                if(visited[nextX][nextY][dir]>next){
                    visited[nextX][nextY][dir] = next;
                    q.add(new int[]{nextX, nextY, dir, next});
                }
            }
        }

        int answer = Integer.MAX_VALUE;


        for(int i=0; i<dx.length; i++){ 
            answer = Math.min(answer, visited[end[0]][end[1]][i]);
        }


        System.out.println(answer);

        
    }
}