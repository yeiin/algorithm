import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine()); 
        int[] arr = new int[count+1];

        int max = 0;
        
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(br.readLine() );
            max = Math.max(max, arr[i]);
        }
       
        long[] fx = new long[max+1];
        long[] gx = new long[max+1];


        for(int i= 1; i<= max; i++){
            for(int j = i; j<=max; j+=i){
                fx[j] += i;
            }
        }

        for(int i=1; i<=max; i++){
            gx[i] = gx[i-1] + fx[i];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(gx[arr[i]]).append("\n");
        }

        System.out.print(sb);
    }

}