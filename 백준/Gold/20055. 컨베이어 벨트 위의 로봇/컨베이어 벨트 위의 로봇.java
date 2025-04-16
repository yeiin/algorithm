import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] belts = new int[2*n];
        boolean[] robots = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<2*n; i++){
            belts[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;

        while (true) {

            int zeroCount = 0;

            for(int i=0; i<belts.length; i++){
                if(belts[i]==0){
                    zeroCount ++;
                }
            }

            if(zeroCount>=k){
                break;
            }

            int temp = belts[belts.length-1];

            for(int i = belts.length-1; i>0; i--){
                belts[i] = belts[i-1];
            }

            belts[0] = temp;

            for (int i = n - 1; i > 0; i--) {
                robots[i] = robots[i - 1];
            }

            robots[0] = false;
            robots[n-1] = false;

            for (int i = robots.length - 1; i > 0; i--) {
                if (robots[i - 1] && !robots[i] && belts[i] > 0) {
                    belts[i]--;
                    robots[i] = true;
                    robots[i - 1] = false;
                }
            }

            if (belts[0] > 0) {
                robots[0] = true;
                belts[0]--;
            }

            count++;
        }

        System.out.println(count);
    }
}