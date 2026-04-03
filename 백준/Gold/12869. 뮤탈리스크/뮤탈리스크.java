import java.io.*;
import java.util.*;

class Main{
    static int n;
    static int[][] finds = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 3, 9}, {1, 9, 3}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];

        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[][][] dp = new int[arr[0]+1][arr[1]+1][arr[2]+1];

        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        int answer = 0;
        Queue<int[]> q = new LinkedList();
        q.add(arr);
        dp[arr[0]][arr[1]][arr[2]] = 0;

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            if(curr[0]==0 && curr[1]==0 && curr[2]==0){
                answer = dp[curr[0]][curr[1]][curr[2]];
                break;
            }

            for(int[] find: finds){
                int[] next = curr.clone();
                for(int f=0; f<find.length; f++){
                    next[f] -= find[f];
                }

                next[0] = Math.max(next[0], 0);
                next[1] = Math.max(next[1], 0);
                next[2] = Math.max(next[2], 0);

                if(dp[next[0]][next[1]][next[2]]!=-1) continue;
                dp[next[0]][next[1]][next[2]] = dp[curr[0]][curr[1]][curr[2]] + 1;
                q.add(next);
            }
        }
        
        System.out.println(answer);
    }
}