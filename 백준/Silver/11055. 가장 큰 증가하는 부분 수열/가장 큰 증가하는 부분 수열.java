import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] numbers = new int[n];
        int[] dp = new int[n];
        int result = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++){
            if(dp[i]==0){
                dp[i] = numbers[i];
            }

            for(int j=0; j<i; j++){
                if(numbers[i]>numbers[j]){
                    dp[i] = Math.max(dp[i], dp[j]+numbers[i]);
                }
            }

            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}