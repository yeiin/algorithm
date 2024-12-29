import java.util.*;
import java.io.*;

public class Main{

    
    public static class Node{
        int x;
        int y;
        int count = 0;
        
        public Node(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Queue<Node> q = new LinkedList<>();
        int[][] boxs = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int number = 0;
        int finished = n*m;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                boxs[i][j] = Integer.parseInt(st.nextToken());
                if(boxs[i][j]==1){
                    q.add(new Node(i, j, 0));
                }

                if(boxs[i][j]==-1){
                    finished -=1;
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){

            Node curr = q.poll();
            number += 1;

            if(number==finished){
                System.out.println(curr.count);
                return;
            }

            for(int k=0; k<4; k++){
                int nextX = curr.x+dx[k];
                int nextY = curr.y +dy[k];
                if(nextX>=0 && nextX<n && nextY>=0 && nextY<m){
                    if(boxs[nextX][nextY] == 0 && !visited[nextX][nextY]){
                        visited[nextX][nextY] = true;
                        q.add(new Node(nextX, nextY, curr.count+1));
                    }
                    
                }
            }
        }
        System.out.println(-1);
    }


}