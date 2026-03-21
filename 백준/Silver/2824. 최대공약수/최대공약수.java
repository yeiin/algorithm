import java.io.*;
import java.util.*;

class Main {
    static long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        long[] A = new long[a];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < a; i++) A[i] = Long.parseLong(st.nextToken());

        int b = Integer.parseInt(br.readLine());
        long[] B = new long[b];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < b; i++) B[i] = Long.parseLong(st.nextToken());

        long result = 1;
        boolean overflow = false;

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                long g = gcd(A[i], B[j]);
                if (g > 1) {
                    A[i] /= g;
                    B[j] /= g;

                    result *= g;
                    if (result >= 1000000000L) {
                        overflow = true;
                        result %= 1000000000L;
                    }
                }
            }
        }

        if (overflow) {
            System.out.printf("%09d\n", result);
        } else {
            System.out.println(result);
        }
    }
}