import java.util.*;
import java.io.*;

public class Main{

    static int n;
    static int m;

    static int[][] arr;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int maximum = 0;

    public static void dfs(int x, int y, int sum, int count){
        if(count == 4){
            maximum = Math.max(maximum, sum);
            return;
        }

        for(int i=0; i<4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX>=0 && newX<n && newY>=0 && newY<m){

                if(!visited[newX][newY]){

                    if(count ==2){
                        visited[newX][newY] = true;
                        dfs(x, y, sum + arr[newX][newY], count+1);
                        visited[newX][newY] = false;
                    }

                    visited[newX][newY] = true;
                    dfs(newX, newY, sum + arr[newX][newY], count+1);
                    visited[newX][newY] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                visited[i][j] = true;
                dfs(i, j, arr[i][j], 1);
                visited[i][j] = false;
            }
        }

        System.out.println(maximum);
        
    }
}