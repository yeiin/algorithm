import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
        Deque<Integer> dq = new ArrayDeque<>();
        int number = Integer.parseInt(bf.readLine());

        for(int i=0; i<number; i++){

            String[] arr = bf.readLine().split(" ");

            switch (arr[0]) {
                case "push_front":
                    dq.addFirst(Integer.parseInt(arr[1]));
                    break;
                case "push_back":
                    dq.addLast(Integer.parseInt(arr[1]));
                    break;
                case "pop_front":
                    if(dq.isEmpty()){
                        System.out.println("-1");
                    }else{
                        System.out.println(dq.pollFirst());
                    }
                    break; 
                case "pop_back":
                    if(dq.isEmpty()){
                        System.out.println("-1");
                    }else{
                        System.out.println(dq.pollLast());
                    }
                    break;
                case "size":
                    System.out.println(dq.size());
                    break;
                case "empty":
                    if(dq.isEmpty()){
                        System.out.println("1");
                    }else{
                        System.out.println("0");
                    }
                    break;
                case "front":
                    if(dq.isEmpty()){
                        System.out.println("-1");
                    }else{
                        System.out.println(dq.peekFirst());
                    }
                    break;
                case "back":
                    if(dq.isEmpty()){
                        System.out.println("-1");
                    }else{
                        System.out.println(dq.peekLast());
                    }
                    break; 
            
            }
        }

    }
}