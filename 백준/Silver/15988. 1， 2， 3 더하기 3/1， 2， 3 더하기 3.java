import java.util.*;

public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long[] arr = new long[10000001];

        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 4;

        for(int i=0; i<num; i++){
            int number = sc.nextInt();
            for(int j=4; j<=number; j++){
                arr[j] = (arr[j-1] + arr[j-2] + arr[j-3])%1000000009;
            }
            System.out.println(arr[number]%1000000009);
        }

        sc.close();
    }
}