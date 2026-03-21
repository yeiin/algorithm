import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> answer = new LinkedList<>();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        boolean[] nPrimes = new boolean[b+1];
        
        for(int i=2; i<=b; i++){

            if(nPrimes[i]) continue;
            boolean isPrime = true;
            for(int j=2; j<=Math.sqrt(i); j++){
                if(i%j==0){
                    isPrime = true;
                }
            }

            if(isPrime){
                if(i>=a) answer.add(i);

                int temp = i+i;
                while(temp<=b){
                    nPrimes[temp] = true;
                    temp+=i;
                }

            }
        }

        for(int c: answer){
            System.out.println(c);
        }
    }
}