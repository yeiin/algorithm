import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        int max = arr[0];

        for(int i=1; i<dp.length; i++){

            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            max = Math.max(dp[i], max);
            
        }

        System.out.println(max);

    }
}