import java.util.*;
import java.io.*;
import java.lang.reflect.Array;


public class Main{

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] dp = new int[n];
        int max = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        

        for(int i=0; i<n; i++){
            if(dp[i]==0){
                dp[i]=1;
            }

            for(int j=0; j<i; j++){
                if(arr[j]>arr[i]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }
}