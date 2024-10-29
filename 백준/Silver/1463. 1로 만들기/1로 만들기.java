import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        int number = sc.nextInt();
        sc.close();
       
        int[] arr = new int[number+1];
        Arrays.fill(arr, 1000000);
        arr[number]=0;

        for(int i=number; i>0; i--){
            if(i*3<=number){
                arr[i] = Math.min(arr[i],arr[i*3]+1);
            }
            if(i*2<=number){
                arr[i] = Math.min(arr[i],arr[i*2]+1);
            }
            if(i+1<=number){
                arr[i] = Math.min(arr[i],arr[i+1]+1);
            }
        }

        System.out.println(arr[1]);

    }
    
}
