import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        int count = 0;
        int value = 10;
        int offset = 1;

        for(int i=1; i<=number; i++){

            if(i%value == 0){
                offset += 1;
                value *= 10;
            }

            count += offset;
        }
        
       
        System.out.println(count);

    }
}