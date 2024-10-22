import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int t;
        
        
        if(a<b){
            t = a;
            a = b;
            b = t;
        }
        t = a * b;

        while(b!=0){
            int r = a % b;
            a = b;
            b = r;
        }

        System.out.println(a);
        System.out.println(t/a);
        sc.close();
    }

}
