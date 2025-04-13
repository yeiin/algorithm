import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int answer = 2*n*m;

        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for(int i = 0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i==0){
                    answer += arr[i][j];
                }else{
                    answer += Math.max(arr[i][j]-arr[i-1][j], 0);
                }
            }
        }

        for(int j = m-1; j>=0; j--){
            for(int i=0; i<n; i++){
                if(j==m-1){
                    answer += arr[i][j];
                }else{
                    answer += Math.max(arr[i][j]-arr[i][j+1], 0);
                }
            }
        }

        
        for(int i = n-1; i>=0; i--){
            for(int j=0; j<m; j++){
                if(i==n-1){
                    answer += arr[i][j];
                }else{
                    answer += Math.max(arr[i][j]-arr[i+1][j], 0);
                }
            }
        }

        for(int j = 0; j<m; j++){
            for(int i=0; i<n; i++){
                if(j==0){
                    answer += arr[i][j];
                }else{
                    answer += Math.max(arr[i][j]-arr[i][j-1], 0);
                }
            }
        }

        System.out.println(answer);

    }
}