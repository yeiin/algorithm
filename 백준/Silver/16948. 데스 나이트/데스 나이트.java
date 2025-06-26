import java.util.*;
import java.io.*;

public class Main{

    static class Node{
        int x, y;
        int count;

        public Node(int x, int y, int count){
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dx = {-2, -2, 0, 0 , 2, 2};
        int[] dy = {-1, 1, -2, 2, -1, 1};

        int[][] chess = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] start = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        int[] end = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start[0], start[1], 0));
        visited[start[0]][start[1]] = true;

        int answer = Integer.MAX_VALUE;

        while(!q.isEmpty()){

            Node curr = q.poll();

            if(curr.x == end[0] && curr.y == end[1]){
                answer = Math.min(answer, curr.count);
                continue;
            }

            if(curr.count>= answer) continue;

            for(int i=0; i<dx.length; i++){

                int nX = curr.x + dx[i];
                int nY = curr.y + dy[i];

                if(nX>=0 && nX<n && nY>=0 && nY<n && !visited[nX][nY]){
                    visited[nX][nY] = true;
                    q.add(new Node(nX, nY, curr.count+1));
                }
            }
        }

        if(answer == Integer.MAX_VALUE) answer = -1;

        System.out.println(answer);

    }

}