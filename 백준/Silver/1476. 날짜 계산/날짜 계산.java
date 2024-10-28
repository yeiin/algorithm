import java.util.*;

public class Main{

 public static void main(String[] args){
    int[] boundary = {15, 28, 19};
    int[] sYear = {1, 1, 1};
    int year = 1;
    int[] jYear = new int[3];

    Scanner sc = new Scanner(System.in);

    for(int i=0; i<3; i++){
        jYear[i] = sc.nextInt();
    }
    sc.close();

    while(true){
        if(sYear[0]==jYear[0] && sYear[1]==jYear[1] && sYear[2]==jYear[2]){
            break;
        }

        for(int i= 0; i<3; i++){
            if(sYear[i]==boundary[i]){
                sYear[i] = 1;
            }else{
                sYear[i] += 1;
            }
        }
        year += 1;
    }

    System.out.println(year);
 }   
}