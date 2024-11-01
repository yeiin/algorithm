import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[A];
        int[] dp = new int[A];
        
        for(int i=0; i<A; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<A; i++){

            if(dp[i]==0){
                dp[i] += 1;
            }

            for(int j=0; j<=i; j++){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[j]+1, dp[i]);
                }
            }
        }

        Arrays.sort(dp);
        System.out.println(dp[dp.length-1]);
         
    }
}