import java.util.*;
import java.io.*;

public class Main{

    static class Node{
        int x;
        int y;
        int count;

        public Node(int x, int y, int count){
            this.x = x; 
            this.y = y;
            this.count = count;
        }

    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];
        int[][] visited = new int[N][M];
        Queue<Node> q = new LinkedList<>();
        int[] dx = {-1,1,0,0};
        int[] dy= {0,0,-1,1};

        for(int i=0; i<N; i++){
            String[] numbers = br.readLine().split("");
            for(int j=0; j<M; j++){
                arr[i][j] = Integer.parseInt(numbers[j]);
            }
        }
        
        q.add(new Node(0, 0, 1));
        visited[0][0]=1;

        while(!q.isEmpty()){
            Node curr = q.poll();
            
            if(curr.x == N-1 && curr.y == M-1){
                System.out.println(curr.count);
                break;
            }

            for(int k=0; k<4; k++){
                if(curr.x+dx[k]>=0 && curr.x+dx[k]<N && curr.y+dy[k]>=0 && curr.y+dy[k]<M){
                    if(arr[curr.x+dx[k]][curr.y+dy[k]]==1 && visited[curr.x+dx[k]][curr.y+dy[k]]==0){
                        q.add( new Node(curr.x+dx[k],curr.y+dy[k], curr.count+1));
                        visited[curr.x+dx[k]][curr.y+dy[k]] = 1;
                    }
                }
            }

        }



    }
}