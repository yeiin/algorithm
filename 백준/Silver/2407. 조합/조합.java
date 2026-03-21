import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if(n-m < m){
            m = n-m;
        }

        BigInteger answer = BigInteger.ONE;

        for (int i = 1; i <= m; i++) {
            answer = answer.multiply(BigInteger.valueOf(n - i + 1));
            answer = answer.divide(BigInteger.valueOf(i));
        }

        System.out.println(answer);
    }
}