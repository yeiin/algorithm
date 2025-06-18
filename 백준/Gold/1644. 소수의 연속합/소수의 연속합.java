import java.util.*;
import java.io.*;

class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> decimals = new ArrayList<>();
        boolean[] visited = new boolean[n+1];

        int answer = 0;

        for(int i=2; i<=n; i++){
            if(!visited[i]){
                int temp = i;
                decimals.add(temp);

                while(temp<=n){
                    visited[temp] = true;
                    temp += i;
                }
            }
        }

        int left = 0;
        int right = 0;
        int sum = 0;

        while(true){
            if(sum==n){
                answer++;
            }

            if(sum>=n){
                sum -= decimals.get(left++);
            }else if(right==decimals.size()){
                break;
            }else{
                sum += decimals.get(right++);
            }
        }

        System.out.println(answer);

    }
}