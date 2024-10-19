import java.util.Scanner;

public class Main {

    public static int findNum(int num){
        
        int count = 0;
        long multiNum = 0;

        while(true){

            multiNum = (multiNum * 10 + 1)%num;
            count += 1;
            
            if(multiNum == 0){
                break;
            }
            
    
        }
        return count;

    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()){
            System.out.println(findNum(sc.nextInt()));
        }
        
    }
}