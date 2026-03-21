import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[] nPrimes = new boolean[10001];

        for(int i=2; i<=10000; i++){
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

                while(temp<=10000){
                    nPrimes[temp] = true;
                    temp+=i;
                }
            }
        }


        for(int i=0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[2];
            arr[1] = Integer.MAX_VALUE;

            for(int j=2; j<=num/2; j++){
                if(!nPrimes[j] && !nPrimes[num-j]){
                    if(arr[1]-arr[0]> j-(num-j)){
                        arr[0] = j;
                        arr[1] = num-j;
                    }
                }
            }
            System.out.println(arr[0]+" "+arr[1]);
        }
    }
}