import java.util.*;
import java.io.*;

class Main{

    static int n;
    static int[] numbers;
    static int[] operations = new int[4];

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;


    public static void dfs(int depth, int result){

        if(depth == numbers.length-1){
            max = Math.max(result, max);
            min = Math.min(result, min);
            return;
        }

        for(int i=0; i<4; i++){
            if(operations[i]>0){
                operations[i]--;
                if(i==0){
                    dfs(depth+1, result+numbers[depth+1]);
                }else if(i==1){
                    dfs(depth+1, result-numbers[depth+1]);
                }else if(i==2){
                    dfs(depth+1, result*numbers[depth+1]);
                }else{
                    if(result<0){
                        dfs(depth+1, -1 * (Math.abs(result)/numbers[depth+1]));
                    }else{
                        dfs(depth+1, result/numbers[depth+1]);
                    }
                    
                }
                operations[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        numbers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            operations[i] = Integer.parseInt(st.nextToken());
        }


        dfs(0, numbers[0]);

        System.out.println(max);
        System.out.println(min);
    }
}