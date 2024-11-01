import java.util.*;
import java.io.*;

public class Main{

    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[N+1];
        sc.close();

        if(N == 1){
            System.out.println(1);
            return;
        }
        
        arr[1] = 1;
        arr[2] = 1;

        for(int i=3; i<N+1; i++){
            arr[i] = arr[i-1]+arr[i-2];
        } 

        System.out.println(arr[N]);
        
    }
}