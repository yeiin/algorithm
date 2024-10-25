import java.util.*;

public class Main{

    public static boolean isPrime(int number){

        if(number == 1){
            return false;
        }

        for(int j = 2; j<=Math.sqrt(number); j++){
            if(number%j==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        for(int i = m; i<=n; i++){
            if(isPrime(i)){
                System.out.println(i);
            }
        }
       
        sc.close();

    }

    
}