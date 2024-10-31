import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(bf.readLine());
        boolean check = false;

        for(int i=0; i<number; i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            check = false;
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            for(int j=x; j<=(m*n); j+=m){
                if(j % n == y){
                    System.out.println(j+1);
                    check = true;
                    break;
                }
            }

            if(!check){
                System.out.println(-1);
            }


        }

    }
}