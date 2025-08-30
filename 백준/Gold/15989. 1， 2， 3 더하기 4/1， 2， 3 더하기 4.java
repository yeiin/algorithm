import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] inputs = new int[T];
        int max = 0;

        for(int t=0; t<T; t++){
            inputs[t] = Integer.parseInt(br.readLine());
            max = Math.max(max, inputs[t]);
        }

        int[] dp = new int[max+1];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for(int i=4; i<=max; i++){
            dp[i] = dp[i-1] + dp[i-2] - dp[i-3];

            if((i-3)%3==0) dp[i]++;
        }

        for(int t=0; t<T; t++){
            System.out.println(dp[inputs[t]]);
        }


    }
}