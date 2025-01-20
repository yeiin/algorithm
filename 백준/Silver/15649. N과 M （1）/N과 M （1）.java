import java.util.*;

public class Main{

    static int n,m;
    static boolean[] visited;
    static int[] sequence;

    public static void dfs(int node, int depth){

        if(depth == m){
            for(int i=0; i<m; i++){
                System.out.print(sequence[i]+" ");
            }
            System.out.println();
        }else{
            for(int i=1; i<=n; i++){
                if(!visited[i]){
                    visited[i]=true;
                    sequence[depth]=i;
                    dfs(i, depth+1);
                    visited[i]=false;
                }
            }
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        visited = new boolean[n+1];
        sequence = new int[m];

        dfs(1, 0);

        sc.close();
        
    }
}