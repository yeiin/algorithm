import java.io.*;

class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int max = 0;

        int[] arr = new int[T];

        

        for(int t=0; t<T; t++){
            arr[t] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[t]);
        }

        long[] dp = new long[max+1];
        dp[0] = 1;

        for (int i=2; i<=max; i+=2) {
            for (int j=0; j<i; j+=2) {
                dp[i] = (dp[i] + dp[j] * dp[i - 2 - j]) % 1000000007;
            }
        }

         for(int t=0; t<T; t++){
            System.out.println(dp[arr[t]]);
        }
    }
}