import java.util.*;
import java.io.*;


class Main{
    
    static int n;
    static int m;
    static String[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean find = false;

    public static void dfs(int x, int y, int goalX, int goalY, String color, int count){

        visited[x][y] = true;

        for(int i=0; i<dx.length; i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX>=0 && nextX<n && nextY>=0 && nextY<m){
                if(map[nextX][nextY].equals(color)){

                    if(!visited[nextX][nextY]){
                        dfs(nextX, nextY, goalX, goalY, color, count+1);
                    }

                    if(nextX==goalX && nextY==goalY && count>=4){
                        find = true;
                        return;
                    }
                    
                }
            }

            if(find) return;
        }    
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new String[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            map[i] = br.readLine().split("");
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visited = new boolean[n][m];
                dfs(i, j, i, j, map[i][j], 1);
                if(find) break;
            }
        }

        if(find) System.out.println("Yes");
        else System.out.println("No");
        

    }

}