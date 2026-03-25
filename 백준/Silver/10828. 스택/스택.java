import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<num; i++){
            String[] s = br.readLine().split(" ");
            if(s.length == 1){
                switch (s[0]) {
                    case "top":
                        if(stack.isEmpty()) System.out.println(-1);
                        else System.out.println(stack.peek());
                        break;
                    case "size":
                        System.out.println(stack.size());
                        break;
                    case "pop":
                        if(stack.isEmpty()) System.out.println(-1);
                        else System.out.println(stack.pop());
                        break;
                    case "empty":
                        if(stack.isEmpty()) System.out.println(1);
                        else System.out.println(0);
                        break;                
                    default:
                        break;
                }
            }else{
                stack.push(Integer.parseInt(s[1]));
            }
            
        }
    }
}
