import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] arr = new int[number+1];
        arr[1] = 1;

        if(arr.length>=3){
            arr[2] = 2;
        }
        

        for(int i=3; i<= number; i++){
            arr[i] = arr[i-1] + arr[i-2];
            if(arr[i]>10007){
                arr[i] %= 10007;
            }
        }

        System.out.println(arr[number]);
    }
}