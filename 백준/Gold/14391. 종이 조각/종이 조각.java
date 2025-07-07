import java.util.*;
import java.io.*;


public class Main{

    static int n;
    static int m;

    static int[][] arr;
    static boolean[][] horizontal;

    static int answer = 0;


    public static void dfs(int x, int y){
        int sum = 0;

        if(x==n && y==m){

            for(int i=0; i<n; i++){
                int temp = 0;
                for(int j=0; j<m; j++){
                    if(horizontal[i][j]){
                        temp*=10;
                        temp+=arr[i][j];
                    }else{
                        sum+=temp;
                        temp = 0;
                    }
                }
                sum+=temp;
            }


            for(int i=0; i<m; i++){
                int temp = 0;
                for(int j=0; j<n; j++){
                    if(!horizontal[j][i]){
                        temp*=10;
                        temp+=arr[j][i];
                    }else{
                        sum+=temp;
                        temp = 0;
                    }
                }
               sum+=temp;
            }

            
            answer = Math.max(answer, sum);           
            return;
        }
        
        int nextX;
        int nextY;

        if(y+1<m){
            nextX = x;
            nextY = y+1;
        }else if(x+1<n){
            nextX = x+1;
            nextY = 0;
        }else{
            nextX=n;
            nextY=m;
        }
       
       horizontal[x][y] = true;
       dfs(nextX, nextY);
       horizontal[x][y] = false;
       dfs(nextX, nextY);
       

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        horizontal = new boolean[n][m];

        for(int i=0; i<n; i++){
            String[] strings = br.readLine().split("");
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(strings[j]);
            }
        }

        dfs(0, 0);

        System.out.println(answer);

    }
}