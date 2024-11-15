import java.util.*;
import java.io.*;

public class Main{

    static class Node{
        int x;
        int y;

        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int count = 0;
        int max = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    
        Queue<Node> q = new LinkedList<>();
    
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && arr[i][j]==1){
                    q.add( new Node(i, j));
                    visited[i][j] = true;
                    count += 1;
                    int currMax = 0;
                    while(!q.isEmpty()){
                        Node curr = q.poll();
                        currMax+=1;

                        for(int k=0; k<4; k++){
                            int nextX = curr.x + dx[k];
                            int nextY = curr.y + dy[k];

                            if(nextX>=0 && nextX<n && nextY>=0 && nextY<m && arr[nextX][nextY]==1 && !visited[nextX][nextY]){
                                q.add(new Node(nextX, nextY));
                                visited[nextX][nextY] = true;
                                
                            }
                        }
                    }
                    max = Math.max(max, currMax);
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }
}