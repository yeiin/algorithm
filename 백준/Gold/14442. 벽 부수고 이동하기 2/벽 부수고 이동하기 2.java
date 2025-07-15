import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = Integer.MAX_VALUE;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] board = new int[n][m];
        int[][][] visited = new int[n][m][k+1];

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for(int i=0; i<n; i++){
            String[] arr = br.readLine().split("");
            for(int j=0; j<m; j++){
                board[i][j] = Integer.parseInt(arr[j]);
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0});
        visited[0][0][0] = 1;

        while (!q.isEmpty()){
            int[] curr = q.poll();

            if(curr[0]==n-1 && curr[1]==m-1){
                answer = Math.min(answer, visited[curr[0]][curr[1]][curr[2]]);
                continue;
            }

            for(int i=0; i<dx.length; i++){
                int nX = curr[0] + dx[i];
                int nY = curr[1] + dy[i];

                if(nX>=0 && nX<n && nY>=0 && nY<m){
                    if(board[nX][nY]==0 && visited[nX][nY][curr[2]]==0){
                        q.add(new int[]{nX, nY, curr[2]});
                        visited[nX][nY][curr[2]] = visited[curr[0]][curr[1]][curr[2]]+1;
                    }else if(curr[2]<k && visited[nX][nY][curr[2]+1]==0){
                        q.add(new int[]{nX, nY, curr[2]+1});
                        visited[nX][nY][curr[2]+1] = visited[curr[0]][curr[1]][curr[2]]+1;
                    }
                }
            }
        }

        if(answer == Integer.MAX_VALUE) answer = -1;
        
        System.out.println(answer);

    }
}