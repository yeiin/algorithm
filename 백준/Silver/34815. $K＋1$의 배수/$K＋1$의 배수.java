import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (K % 2 == 0) {
            System.out.println("YES");
        } else {
            System.out.println(N >= K + 1 ? "YES" : "NO");
        }
    }    
}
