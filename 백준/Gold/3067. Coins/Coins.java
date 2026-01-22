import java.util.*;
import java.io.*;

class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for(int t =0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] coins = new int[n];
            for(int c=0; c<n; c++){
                coins[c] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            
            int[] numbers = new int[m+1];
            numbers[0] = 1;

            for (int i=0; i<n; i++) {
                int c = coins[i];
                for (int j=c; j<=m; j++) {
                    numbers[j] += numbers[j-c];
                }
            }

            System.out.println(numbers[m]);
           
        }
        
    }
    
}

