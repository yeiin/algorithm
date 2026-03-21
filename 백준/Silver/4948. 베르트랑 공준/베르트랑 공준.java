import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        
        boolean[] nPrimes = new boolean[246913];
        nPrimes[1] = true;

        for(int i=2; i<=246912; i++){
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

                while(temp<=246912){
                    nPrimes[temp] = true;
                    temp+=i;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n==0) break;

            int cnt = 0;
           
            for(int i=n+1; i<=2*n; i++){
                if(!nPrimes[i]) cnt++;
            }

            System.out.println(cnt);
        }
        
    }
}