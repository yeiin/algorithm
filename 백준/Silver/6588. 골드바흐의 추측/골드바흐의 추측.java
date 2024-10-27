import java.util.*;


public class Main{
    static boolean[] primeNumber = new boolean[1000001];    
    
    public static boolean isPrime(int number){
        
        for(int i=2; i<= Math.sqrt(number); i++){
            if(number % i ==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){

        for(int i=3; i<1000001;i++){
            primeNumber[i] = isPrime(i);
        }

        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int[] result={0,0};

        while(number != 0){
            
            for(int j=3; j<number; j++){
                if(primeNumber[j] && primeNumber[number-j]){
                   result[0] = j;
                   result[1] = number-j;
                    break;
                }

            }
            if(result[0] != 0){
                System.out.println(number + " = " + result[0]+" + " + result[1]);
                result[0] = 0;
                result[1] = 0;
            }else{
                System.out.println("Goldbach's conjecture is wrong.");
            }
            
            number = sc.nextInt();
        }

        sc.close();
    }
}