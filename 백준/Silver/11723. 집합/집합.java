import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());
        StringTokenizer st;
        boolean[] s = new boolean[21];

        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<number; i++){
            st = new StringTokenizer(br.readLine());
            String instr = st.nextToken();
            if(instr.equals("add")){
                int addNum = Integer.parseInt(st.nextToken());
                s[addNum] = true;
            }else if(instr.equals("check")){
                int checkNum = Integer.parseInt(st.nextToken());
                if(s[checkNum]){
                    sb.append(1+"\n");
                }else{
                    sb.append(0+"\n");
                }
            }else if(instr.equals("remove")){
                int removeNum = Integer.parseInt(st.nextToken());
                s[removeNum] = false;
            }else if(instr.equals("toggle")){
                int toggleNum = Integer.parseInt(st.nextToken());
                if(s[toggleNum]){
                    s[toggleNum] = false;
                }else{
                    s[toggleNum] = true;
                }
            }else if(instr.equals("all")){
                for(int j=1; j<s.length; j++){
                    s[j] = true;
                }
            }else{
                for(int j=1; j<s.length; j++){
                    s[j] = false;
                }
            }

        }

        System.out.println(sb.toString());
        
    }
}