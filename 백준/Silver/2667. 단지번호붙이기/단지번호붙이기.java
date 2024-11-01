import java.util.*;
import java.io.*;

public class Main{

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
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[][] arr= new int[N][N];
        int[][] visited = new int[N][N];
        
        List result = new ArrayList();
        int[] dx = {-1,1, 0,0};
        int[] dy = {0,0,-1,1};

        for(int i=0; i<N; i++){
            String[] numbers = br.readLine().split("");
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(numbers[j]);
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j]==1 && visited[i][j]==0){

                    Queue<Node> q = new LinkedList<>();
                    q.add(new Node(i, j));
                    visited[i][j] = 1;
                    int count = 0;

                    while(!q.isEmpty()){
                        Node curr = q.poll();
                        count += 1;

                        for(int k=0; k<4; k++){
                            if(curr.x + dx[k]>=0 && curr.x + dx[k]<N && curr.y + dy[k]>=0 && curr.y + dy[k]<N){
                                if(arr[curr.x+dx[k]][curr.y+dy[k]]==1 && visited[curr.x+dx[k]][curr.y+dy[k]] == 0){
                                    q.add(new Node(curr.x+dx[k],curr.y+dy[k]));
                                    visited[curr.x+dx[k]][curr.y+dy[k]] = 1;
                                }
                            }
                           
                        }
                    }
                    result.add(count);
                }
            }
        }

        System.out.println(result.size());
        Collections.sort(result);
       result.forEach(r -> System.out.println(r));




    }
}