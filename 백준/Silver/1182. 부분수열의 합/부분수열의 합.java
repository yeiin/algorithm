import java.util.*;
import java.io.*;

public class Main{
    static int n;
    static int k;
    static int[] arr;
    static int count;

    public static void dfs(int index, int depth, long sum){
        

        if(index==n){
            if(sum == k && depth !=0){
                count++;
            }
            return;
        }

        dfs(index+1, depth+1, sum+arr[index]);
        dfs(index+1, depth, sum);

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        count = 0;

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0,0);

        System.out.println(count);

    }
}