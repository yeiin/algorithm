import java.util.*;
import java.io.*;

public class Main{

    static int r,c;
    static char[][] arr;
    static boolean[] visited;
    static int max;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    


   public static void dfs(int x, int y, int count){

    if(visited[(int)arr[x][y]-65]){
        max = Math.max(max, count);
    }else{
        visited[(int)arr[x][y]-65] = true;

        for(int i=0; i<4; i++){
            int newX = x + dx[i];
            int newY = y + dy[i];

            if(newX>=0 && newX<r && newY >=0 && newY < c){
                dfs(newX, newY, count+1);
            }
        }

        visited[(int)arr[x][y]-65] = false;
    }
   }

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        arr = new char[r][c];
        visited = new boolean[26];
        max = 1;

        for(int i=0; i<r; i++){
            String s = br.readLine();
            for(int j=0; j<c; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        dfs(0,0,0);

        System.out.println(max);

    }
}