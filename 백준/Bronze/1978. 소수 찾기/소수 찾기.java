import java.util.ArrayList;
import java.util.*;

public class Main {

    public static boolean isPrime(int number){

        if(number == 1){
            return false;
        }

        for (int j=2; j<=Math.sqrt(number); j++){
            if(number %j == 0){
               return false;

            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        int n = sc.nextInt();
        int count = 0;

        List<Integer> numbers = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            numbers.add(sc.nextInt());
        }

        for(int i=0; i<n; i++){
            if(isPrime(numbers.get(i))){
                count += 1;
        
            }
        }

        System.out.println(count);
        sc.close();
    }
}
