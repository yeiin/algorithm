import java.io.*;
import java.util.*;

public class Main{
    static int n;
    static int[] numbers;
    static int[] operations;
    static int[] arr;

    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void calculate(){
        int result = numbers[0];
        
        for(int i=1; i<n; i++){
            if(arr[i]==0){
                result += numbers[i];
            }else if(arr[i]==1){
                result -= numbers[i];
            }else if(arr[i]==2){
                result *= numbers[i];
            }else{
                if(result<0 && numbers[i]>0){
                    int temp = Math.abs(result);
                    temp /= numbers[i];
                    if(numbers[i]>0){
                         result = -1*temp;
                    }else{
                        result = temp;
                    }
                }else{
                    result /=  numbers[i];
                }            
            }
        }

        min = Math.min(min, result);
        max = Math.max(max, result);
    }

    public static void dfs(int depth){
        if(depth == n){
            calculate();
            return;
        }

        for(int i=0; i<4; i++){
            if(operations[i]>0){
                arr[depth] = i;
                operations[i]--;
                dfs(depth+1);
                operations[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        numbers = new int[n];
        operations = new int[4];
        arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            operations[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1);

        System.out.println(max);
        System.out.println(min);

    }
}