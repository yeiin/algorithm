import java.util.*;

public class Main{

    static List<Integer> dfsResult = new ArrayList<>();
    static List<Integer> bfsResult = new ArrayList<>();
    static boolean[] visited;
    static int[][] nodes;
    static int N;
    static int M;
    static int V;

    public static void dfs(int node){

        visited[node] = true;
        dfsResult.add(node);

        for(int i=1; i < N+1; i++){
            if(nodes[node][i]==1 && !visited[i]){
                dfs(i);
            }
        }


    }
    public static void bfs(){
        Queue<Integer> q = new LinkedList();
        boolean[] bfsVisited = new boolean[N+1];
        q.add(V);
        bfsVisited[V] = true;

        while(!q.isEmpty()){
            int curr = q.poll();
            bfsResult.add(curr);

            for(int j=1; j<N+1; j++){
                if(nodes[curr][j]==1 && !bfsVisited[j]){
                    q.add(j);
                    bfsVisited[j] = true;
                }
            }
        }

    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();
        visited = new boolean[N+1];
        nodes = new int[N+1][N+1];

        for(int i=0; i<M; i++){
            int start = sc.nextInt();
            int finish = sc.nextInt();
            nodes[start][finish] = 1;
            nodes[finish][start] = 1;
        }

        dfs(V);
        bfs();

        dfsResult.forEach(
            d -> System.out.print(d + " ")
        );
        System.out.println();

        bfsResult.forEach(
            b -> System.out.print(b + " ")
        );
    }

}