import java.io.*;
import java.util.*;

class Main{

    public static long two(long n){
        long result = 0;
        while(n>=2){
            result += n/2;
            n /= 2; 
        }
        return result;
    }

    public static long five(long n){
        long result = 0;
        while(n>=5){
            result += n/5;
            n /= 5; 
        }
        return result;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        long t = two(n) - two(n-m)- two(m);
        long f = five(n) - five(n-m) - five(m);

        System.out.println(Math.min(t, f));

    }
}