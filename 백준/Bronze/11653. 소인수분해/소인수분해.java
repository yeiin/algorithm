import java.io.*;

class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int n = Integer.parseInt(br.readLine());


        int num = n;
        for(int i=2; i<=n; i++){
            if(num==1) break;

            while(true){
                if(num%i!=0) break;

                sb.append(i+"\n");
                num/=i;
            }

        }
        
        System.out.println(sb);
    }
}