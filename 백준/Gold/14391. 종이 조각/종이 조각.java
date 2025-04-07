import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];

        int max = 0;

        for(int i=0; i<n; i++){
            String input = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] = input.charAt(j)-'0';
            }
        }

        for(int b=0; b<(1<<(n*m)); b++){
            int sum = 0;

            for(int i=0; i<n; i++){
                int num = 0;
                for(int j=0; j<m; j++){
                    int idx = i * m + j;
                    if ((b & (1 << idx)) == 0) {
                        num = num * 10 + arr[i][j];
                    } else {
                        sum += num;
                        num = 0;
                    }
                }
                sum += num;
            }

            for (int j = 0; j < m; j++) {
                int num = 0;
                for (int i = 0; i < n; i++) {
                    int idx = i * m + j;
                    if ((b & (1 << idx)) != 0) {
                        num = num * 10 + arr[i][j];
                    } else {
                        sum += num;
                        num = 0;
                    }
                }
                sum += num;
            }

            max = Math.max(max, sum);
        }
        
        System.out.println(max);

    }
}