import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        
        long x = 15*100000;
        long k = n % x;

        long a = 0;
        long b = 1;
        long answer = 1;

        for(int i=2; i<=k; i++){
            answer = (a+b)%1000000;
            a = b;
            b = answer;
        }

        System.out.println(answer);
    }
}