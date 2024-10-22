import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
    
        long result = 0;

        for(int j=1; j<=num; j++){
            result = result + (num/j) * j;
        
        }

        System.out.println(result);

        scan.close();
    }   

}
 