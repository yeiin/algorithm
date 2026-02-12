import java.io.*;
import java.util.*;

public class Main{
    static Set<Long> answers = new TreeSet<>();
    static int N;

    public static void dfs(int depth, long num){
        if(num<=1) return;
        if(depth==N){
            if(!answers.contains(num)) {
                answers.add(num);
            }
            return;
        }

        dfs(depth+1, num*2);
        
        if((num-1)%3==0 && ((num-1)/3) % 2 == 1){
            dfs(depth+1, (num-1)/3);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());


        if(N==1){
            System.out.println(1);
            System.out.println(1);
            return;
        }

        dfs(2, 2);
        
        System.out.println(answers.size());
        for(long a: answers){
            System.out.println(a);
        }
    }
}