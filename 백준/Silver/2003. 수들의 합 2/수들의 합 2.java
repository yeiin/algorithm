import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] numbers = new int[n];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }


        for(int i=0; i<n; i++){
            int temp = 0;
            for(int j=i; j<n; j++){
                temp += numbers[j];

                if(temp==m) answer++;

                if(temp>m) break;
            }
        }

        System.out.println(answer);
    }

}