import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());

        int[] arr = new int[number];

        int index = -1;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<number; i++){
            arr[i] = Integer.parseInt(st.nextToken());

        }

        for(int j = number-1; j>0; j--){
            if(arr[j-1]<arr[j]){
                index = j-1;
                break;
            }
        }

        if(index == -1){
            System.out.println(-1);
            return;
        }
        
        int swapIndex = -1;

        for(int j=number-1; j>index; j--){
            if(arr[index]<arr[j]){
                swapIndex = j;
                break;
            }
        }

        int temp = arr[index];
        arr[index] = arr[swapIndex];
        arr[swapIndex] = temp;

        for(int i=0; i<index+1; i++){
            System.out.print(arr[i]+" ");
        }

        for(int i=number-1; i>index; i--){
            System.out.print(arr[i]+" ");
        }
    }
}