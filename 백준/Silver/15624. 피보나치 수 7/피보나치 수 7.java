import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int a = 0;
        int b = 1;
        int answer = 1;

        for(int i=2; i<=n; i++){
            answer = (a+b) % 1000000007;
            a = b;
            b = answer;
        }

        System.out.println(answer);
    }
}
