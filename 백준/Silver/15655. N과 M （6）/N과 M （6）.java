import java.util.*;
import java.io.*;

public class Main{

    static int n;
    static int m;
    static int[] numbers;
    static int[] arr;
    static boolean[] visited;

    public static void dfs(int depth, int node){

        if(depth == m){
            for(int i=0; i<m; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }else{
            for(int i=node; i<n; i++){
                if(!visited[i]){
                    arr[depth] = numbers[i];
                    visited[i] = true;
                    dfs(depth+1, i);
                    visited[i] = false;
                }
                
            }
        }

    }

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        numbers  = new int[n];
        visited = new boolean[n];
        arr = new int[m];

        for(int i=0; i<n; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        dfs(0, 0);

    }
}