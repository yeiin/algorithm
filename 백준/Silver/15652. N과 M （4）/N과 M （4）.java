import java.util.*;
import java.io.*;

public class Main{

    static int n;
    static int m;
    static int[] arr;


    static void dfs(int num, int count){

        if(count == m){

            for(int i=0; i<m; i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }

        for(int i=num; i<n; i++){
            arr[count] = i+1;
            dfs(i, count+1);
        }

    }


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[m];

        dfs(0, 0);


        sc.close();
    }

}