import java.util.*;
import java.io.*;

public class Main{
    public static int V;
    public static int E;
    public static List<Integer>[] nodes;
    public static int[] visited;
    public static boolean answer;

    public static void dfs(int node,int color){

        visited[node] = color;

        for(int n :nodes[node]){
       
            if(visited[n] == visited[node]){
                answer = false;
                return;
            }else if(visited[n] == 0){
               dfs(n, 3-color);
            }

        }
    
    }



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int testNum = Integer.parseInt(st.nextToken());

        for(int i=0; i<testNum; i++){
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            nodes = new ArrayList[V];
            visited = new int[V];

            for(int j=0; j<V; j++){
                nodes[j] = new ArrayList();
            }

            for(int j=0; j<E; j++){
                st = new StringTokenizer(br.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                nodes[start-1].add(end-1);
                nodes[end-1].add(start-1);
            }

            answer = true;

            for (int n = 0; n < V; n++) {
                if (visited[n] == 0) {
                    dfs(n, 1);
                    if(!answer){
                        break;
                    }
                }
            }

                
            if(answer){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }

    }
}