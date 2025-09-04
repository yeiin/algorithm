import java.io.*;
import java.util.*;

class Main{

    static int n;
    static int[][][] dp;

    static int find(int h1, int h2, int h3){
        h1 = Math.max(h1, 0);
        h2 = Math.max(h2, 0);
        h3 = Math.max(h3, 0);

        if(h1==0 && h2 ==0 && h3==0){
            return 0;
        }

        if(dp[h1][h2][h3]!=-1) return dp[h1][h2][h3];

        int result = Integer.MAX_VALUE;

        result = Math.min(result, find(h1-9, h2-3, h3-1));
        result = Math.min(result, find(h1-9, h2-1, h3-3));
        result = Math.min(result, find(h1-3, h2-9, h3-1));
        result = Math.min(result, find(h1-3, h2-1, h3-9));
        result = Math.min(result, find(h1-1, h2-3, h3-9));
        result = Math.min(result, find(h1-1, h2-9, h3-3));

        dp[h1][h2][h3] = result+1;

        return dp[h1][h2][h3];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[arr[0]+1][arr[1]+1][arr[2]+1];

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(find(arr[0], arr[1], arr[2]));

    }
}