import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node{
        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
            
        }
    }

    
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<Node> q = new ArrayDeque();
        int[][] miro = new int[m][n];
        int[][] visited = new int[m][n];
        int max = n*m;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for(int i=0; i<m; i++){
            String numbers = br.readLine();
            for(int j=0; j<n; j++){
                miro[i][j] =  Character.getNumericValue(numbers.charAt(j));
                visited[i][j] = max;
            }
        }

        q.add(new Node(0,0));
        visited[0][0] = 0;

        while(!q.isEmpty()){

            Node curr = q.pollFirst();

            if(curr.x == m-1 && curr.y ==n-1){
                System.out.println(visited[m-1][n-1]);
                return;
            }

    

            for(int j=0; j<dx.length; j++){
                int nextX = curr.x+dx[j];
                int nextY = curr.y+dy[j];
                if(nextX>=0 && nextX<m && nextY>=0 && nextY<n && visited[nextX][nextY]==max){
                    if(miro[nextX][nextY]==1){
                        visited[nextX][nextY] = visited[curr.x][curr.y]+1;
                        q.add(new Node(nextX, nextY));
                    }else{
                        visited[nextX][nextY] = visited[curr.x][curr.y];
                        q.addFirst(new Node(nextX, nextY));
                    }
                    
                }
            }

        }

    }
}