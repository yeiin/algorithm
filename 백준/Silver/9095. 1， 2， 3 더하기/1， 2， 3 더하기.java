import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int rotation = sc.nextInt();
        int[] arr = new int[12];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for(int i=0; i<rotation; i++){
            int number = sc.nextInt();
           
            for(int j=4; j<=number; j++){
                arr[j] = arr[j-1]+arr[j-2]+arr[j-3];
            }
            System.out.println(arr[number]);
        }
        sc.close();
       
    }
}