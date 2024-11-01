import java.util.*;
import java.io.*;

public class Main{



    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[A];
        int[] dp = new int[A];

        for(int i = 0; i< arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for(int i=0; i<arr.length; i++){
            if(dp[i]==0){
                dp[i] += 1;
            }

            for(int j=i; j<arr.length; j++){
                if(arr[j]>arr[i]){
                    dp[j] = Math.max(dp[i]+1, dp[j]);
                }
            }
        }

        int index = 0;
        int max = 0;
        for(int i =0; i<dp.length; i++){
            if(dp[i] > max){
                index = i;
                max = dp[i];
            }
        }

        System.out.println(max);
        List resultArr = new ArrayList<>();

        for(int j=index; j>=0; j--){
            if(dp[j]==max){
                resultArr.add(arr[j]);
                max -= 1;
            }
        }

        Collections.reverse(resultArr);

        resultArr.forEach(
            result -> System.out.print(result + " ")
        );

    }

}