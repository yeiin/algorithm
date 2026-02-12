import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            int num = Integer.parseInt(br.readLine());

            boolean isPrime = true;
            for(int i=2; i<=Math.sqrt(num+1); i++){
                if((num+1)%i==0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                System.out.println(1);
                System.out.println(1+" "+(1+num));
            }else{
                System.out.println(0);
            }
        }
    }
}