import java.util.*;
import java.io.*;

public class Main {

    static int n, m;
    static int[] numbers;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    static void dfs(int count) {
        if (count == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                arr[count] = numbers[i];
                visited[i] = true;
                dfs(count + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            numbers = new int[n];
            visited = new boolean[n];
            arr = new int[m];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(numbers);

            dfs(0);

            System.out.println(sb); // ✅ 한 번에 출력 (백준 최적화)
        } catch (Exception e) {
            e.printStackTrace(); // ❗ 예외 발생 시 디버깅 용도로 출력
        }
    }
}