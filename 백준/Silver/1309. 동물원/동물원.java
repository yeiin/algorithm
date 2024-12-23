import java.util.*;

public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        long[] lionArr = new long[100001];

        lionArr[1] = 3;
        lionArr[2] = 7;

        for(int i=3; i<=number; i++){
            lionArr[i] = (2*lionArr[i-1] + lionArr[i-2])%9901;
        }

        System.out.println(lionArr[number]%9901);
    }
}