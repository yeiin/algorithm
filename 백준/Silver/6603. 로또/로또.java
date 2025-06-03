import java.io.*;
import java.util.*;

public class Main{

    static StringBuilder sb;

    static int n;
    static int[] numbers;
    static int[] arr;
    static boolean[] visited;

    public static void dfs(int index, int depth){

        if(depth == 6){
            
            for(int i=0; i<arr.length; i++) sb.append(arr[i]+" ");
            sb.append("\n");
            return;
        }

        for(int i=index; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = numbers[i];
                dfs(i, depth+1);
                visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            
            if(n==0) break;

            numbers = new int[n];
            arr = new int[6];
            visited = new boolean[n];
            sb = new StringBuilder();

            for(int i=0; i<n; i++){
                numbers[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(numbers);

            dfs(0,0);

            System.out.print(sb.toString());
            System.out.println();
        }

    }
}