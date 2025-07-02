import java.util.*;
import java.io.*;

public class Main {

    static class Node{
        int x;
        int y;
        int count;
        boolean isBreak;

        public Node(int x, int y, int count, boolean isBreak){
            this.x = x;
            this.y = y;
            this.count = count;
            this.isBreak = isBreak;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        boolean[][][] visited = new boolean[n][m][2];

        int answer = Integer.MAX_VALUE;

        for(int i=0; i<n; i++){
            String[] temp = br.readLine().split("");
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(0, 0, 1, false));

        while(!q.isEmpty()){
            Node curr = q.poll();
           
            if(curr.x == n-1 && curr.y == m-1){
                answer = Math.min(answer, curr.count);
            }

            if(curr.count>=answer) continue;

            for(int i=0; i<dx.length; i++){
                int nextX = curr.x + dx[i];
                int nextY = curr.y + dy[i];

                if(nextX>=0 && nextX <n && nextY>=0 && nextY<m){              
                    if(curr.isBreak){
                        if(map[nextX][nextY]==0 && !visited[nextX][nextY][1]){
                            visited[nextX][nextY][1] = true;
                            q.add(new Node(nextX, nextY, curr.count+1, curr.isBreak));
                        }
                    }else{
                        if(map[nextX][nextY]==0 && !visited[nextX][nextY][0]){
                            visited[nextX][nextY][0] = true;
                            q.add(new Node(nextX, nextY, curr.count+1, curr.isBreak));
                        }else if(map[nextX][nextY]==1 && !visited[nextX][nextY][1]){
                            visited[nextX][nextY][1] = true;
                            q.add(new Node(nextX, nextY, curr.count+1, !curr.isBreak));
                        }
                    }   
                }
            }        
            
        }

    
        if(answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }
}