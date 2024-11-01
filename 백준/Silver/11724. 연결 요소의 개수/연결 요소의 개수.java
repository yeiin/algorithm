import java.util.*;
import java.io.*;

public class Main{
    static int N;
    static int M;
    static int[][] nodes;
    static boolean[] visited;

    public static void dfs(int node){
        visited[node] = true;

        for(int j=1; j<=N; j++){
            if(!visited[j] && nodes[node][j]==1){
                dfs(j);
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nodes = new int[N+1][N+1];
        visited = new boolean[N+1];
        int count = 0;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            nodes[start][end] = 1;
            nodes[end][start] = 1;
        }

        for(int i=1; i<=N; i++){
            if(!visited[i]){
                count += 1;
                dfs(i);
            }
            
        }

        System.out.println(count);

    }
}