import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        br.close();

        for(int i=0; i<S.length(); i++){
            
            String ss = S.substring(0, i+1);
            long num = Long.parseLong(ss);

            int len = ss.length();
            int next = i+1;
            int nextLen = Long.toString(num+1).length();
            boolean isFind = false;

            while(next+nextLen<=S.length()){
                String nextNum = S.substring(next, next+nextLen);

                if(num+1 != Long.parseLong(nextNum)){
                    break;
                }

                if((int)((num+1)/Math.pow(10, len)) != 0){
                    len+=1;
                }
                num++;
                next += len;
                nextLen = Long.toString(num+1).length();

                if(next==S.length()){
                    isFind = true;
                }
            }

            if(i==S.length()-1){
                System.out.println(S +" "+ S);
                break;
            }

            if(isFind){
                System.out.println(ss+" "+S.substring(S.length()-len));
                break;
            }

            
        }

    }
}