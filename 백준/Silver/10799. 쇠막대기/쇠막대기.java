import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(') {
                stack.push(curr);
            } else {
                stack.pop();

                if (s.charAt(i - 1) == '(') {
                    answer += stack.size();
                } else {
                    answer += 1;
                }
            }
        }

        System.out.println(answer);
    }
}