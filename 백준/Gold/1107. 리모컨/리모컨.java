import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int init = 100;
        int goal = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());
        boolean[] button = new boolean[10];
        int minimum = Math.abs(init - goal);


        if(num != 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<num; i++){
                button[Integer.parseInt(st.nextToken())] = true;
            }
        }
    
        if(init == goal){
            System.out.println(0);
            return;
        }

        for(int i=0; i<1000000; i++){
            
            boolean flag = false;
            int cal = 0;

            if(i==0){
                if(button[i]){
                    flag = true;
                }else{
                    cal += 1;
                }
            }else{
                int j = i;
                while (j!=0) {
                    int n = j%10;
                    cal += 1;

                    if(button[n]){
                        flag = true;
                        break;
                    }
                    j /= 10;
                }
            }
            
            if(flag){
                continue;
            }

            int result = cal + Math.abs(i-goal);
            minimum = Math.min(minimum, result);

        }
        
        System.out.println(minimum);
    }
}