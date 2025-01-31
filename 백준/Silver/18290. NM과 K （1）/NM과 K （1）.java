import java.io.*;
import java.util.*;

public class Main{

    static int n;
    static int m;
    static int k;
    static int max;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int[][] arr;
    static boolean[][] visited;

    public static void dfs(int x, int y, int index, int result){

        if(index == k){
            max = Math.max(max, result);
            return;
        }else{
            for (int i = x; i < n; i++) {
                for (int j = y; j < m; j++) {
                    if (!visited[i][j]) {
                        if (check(i, j)) {
                            visited[i][j] = true;
                            dfs(x, y, index + 1, result + arr[i][j]);
                            visited[i][j] = false;
                        }
                    }
                }
            }
         
        }

    }


    public static boolean check(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                if (visited[nextX][nextY]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;

        arr = new int[n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


    
        dfs(0, 0, 0, 0);
       

        System.out.println(max);
        

    }
}