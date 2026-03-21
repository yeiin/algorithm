import java.util.*;
import java.io.*;

public class Main {

    public static int gcd(int a, int b){

        if(a<b){
            int tmp = a;
            a = b;
            b = tmp;
        }

        int r = 0;
        while(b!=0){
            r = a % b;
            a=b;
            b=r;
        }

        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int g = Math.abs(arr[0]-s);

        for(int i=0; i<arr.length-1; i++){
            g = Math.min(g, gcd(Math.abs(arr[i]-s), Math.abs(arr[i+1]-s)));
        }

        System.out.println(g);

    }
}
