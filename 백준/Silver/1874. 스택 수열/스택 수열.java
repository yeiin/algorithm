import java.io.*;
import java.util.*;

public class Main {

    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void push(int num){
        sb.append("+\n");
        stack.push(num);
    }

    public static int pop(){
        sb.append("-\n");
        return stack.pop();
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        
        
        int temp = 0;
        int n = 1;

        while (!stack.isEmpty()||n<=num) {
            temp = Integer.parseInt(br.readLine());

            for(int j=n; j<=temp; j++){
                push(j);
                n++;
            }

            while(!stack.isEmpty()){
                int p = pop();
                if(temp == p) break;
                if(stack.peek() > temp || temp != p){
                    System.out.println("NO");
                    return;
                }
            }
            
        }

        System.out.println(sb.toString());

    }
}
