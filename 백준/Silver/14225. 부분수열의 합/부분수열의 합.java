import java.util.*;
import java.io.*;

public class Main{
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int[] numbers;

    public static void dfs(int depth, int sum){
        
        if(depth == numbers.length) return;

        map.put(numbers[depth]+sum,numbers[depth]+sum);
        
        dfs(depth+1, sum);
        dfs(depth+1, numbers[depth]+sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        numbers = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<numbers.length; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
       
        dfs(0,0);

        for(int i=1; i<2000001; i++){
            if(!map.containsKey(i)){
                System.out.println(i);
                break;
            }
        }
    }
}