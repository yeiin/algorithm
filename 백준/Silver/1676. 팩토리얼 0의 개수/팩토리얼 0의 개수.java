import java.io.*;

class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int temp = n;
        int t = 0;

        while(temp>=2){
            t += temp/2;
            temp /= 2;
        }

        temp = n;
        int f = 0;

        while(temp>=5){
            f += temp/5;
            temp /= 5;
        }

        System.out.println(Math.min(t, f));
    }
}