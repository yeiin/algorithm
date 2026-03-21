import java.io.*;
import java.util.*;

public class Main {
    static int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int g = arr[1] - arr[0];
        for (int i = 2; i < n; i++) {
            g = gcd(g, arr[i] - arr[i - 1]);
        }

        List<Integer> answers = new ArrayList<>();

        for (int i = 2; i * i <= g; i++) {
            if (g % i == 0) {
                answers.add(i);
                if (i != g / i) {
                    answers.add(g / i);
                }
            }
        }

        answers.add(g);
        Collections.sort(answers);

        StringBuilder sb = new StringBuilder();
        for (int a : answers) {
            sb.append(a).append(' ');
        }
        System.out.println(sb);
    }
}