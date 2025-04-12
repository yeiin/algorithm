import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;

        int[][] arr = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int r  = Integer.parseInt(st.nextToken());
        int c  = Integer.parseInt(st.nextToken());
        int d  = Integer.parseInt(st.nextToken());


        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        

        int[] dx = {-1, 0, 1, 0}; 
        int[] dy = {0, 1, 0, -1};

        while(true){

            if(arr[r][c]==0){
                arr[r][c] = 2;
                count++;
            }

            boolean isMoved = false;
            for(int i=0; i<4; i++){
                d = (d + 3) % 4;
                int nextX = r + dx[d];
                int nextY = c + dy[d];

                if (nextX >= 0 && nextX < n && nextY >= 0  && nextY < m && arr[nextX][nextY] == 0) {
                    r = nextX;
                    c = nextY;
                    isMoved = true;
                    break;
                }

            }

            if (!isMoved) {
                int back = (d + 2) % 4;
                int nextX = r + dx[back];
                int nextY = c + dy[back];

                if (nextX < 0|| nextX >= n || nextY < 0 || nextY >= m || arr[nextX][nextY] == 1) {
                    break; 
                } else {
                    r = nextX;
                    c = nextY;
                }
            }

        }

        System.out.println(count);
    }
}