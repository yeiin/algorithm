import java.io.*;
import java.util.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] nPrimes = new boolean[1000001];

        for(int i=2; i<=1000000; i++){
            if(nPrimes[i]) continue;

            boolean isPrime = true;
            for(int j=2; j<= Math.sqrt(i); j++){
                if(i%j == 0){
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                int temp = i+i;

                while(temp<=1000000){
                    nPrimes[temp] = true;
                    temp+=i;
                }
            }
        }


        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            int count = 0;

            for(int j=2; j<=num/2; j++){
                if(!nPrimes[j] && !nPrimes[num-j]){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}