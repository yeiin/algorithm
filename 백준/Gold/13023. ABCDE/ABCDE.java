import java.util.*;
import java.io.*;

public class Main{
    public static int N = 0;
    public static int answer = 0;
    public static boolean[] visited;
    public static List<Integer>[] nodes;

    public static void dfs(int node, int depth){

        if (depth == 5) {
            answer = 1;
            return;
        }
        
        visited[node] = true;

        for(int i : nodes[node]){
            if(!visited[i]){
                dfs(i, depth + 1);
            
            }
        }

        visited[node] = false;

    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        nodes = new ArrayList[N];


        for(int i=0; i<N; i++){
            nodes[i] = new ArrayList();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            nodes[start].add(from);
            nodes[from].add(start);
        }

        for(int i=0; i<N; i++){
            dfs(i, 1);
            if(answer == 1){
                break;
            }
        }

        System.out.println(answer);
    }
}