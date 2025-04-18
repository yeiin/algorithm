import java.io.InputStreamReader;
import java.util.*;

public class Main{

    static int[] arr;
    static boolean[] visited;
    static int n;
    static int m;

    public static void dfs(int node, int depth){

        if(depth==m){
            for(int i=0; i<m; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=node; i<n; i++){

            if(!visited[i]){
                arr[depth] = i+1;
                visited[i] = true;
                dfs(i, depth+1); 
                visited[i] = false;
            }   
        }
        
    }

    public static void main(String[] args) {
    
        Scanner sc = new Scanner(new InputStreamReader(System.in));
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];
        visited = new boolean[n];

        sc.close();

        dfs(0,0);
    }
}