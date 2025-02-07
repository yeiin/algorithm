import java.util.*;
import java.io.*;

public class Main{

    static int n;
    static int m;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int count){

        if(count == m){
            for(int i=1; i<=m; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=n; i++){
            arr[count+1] = i;
            dfs(count+1);
        }

    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m+1];

        dfs(0);

        System.out.print(sb.toString());

    }
}