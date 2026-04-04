import java.util.*;

class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
        int[][] ground = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(ground[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < drops.length; i++) {
            ground[drops[i][0]][drops[i][1]] = i + 1;
        }

        int cols = n - w + 1;
        int rows = m - h + 1;
        int[][] rowMin = new int[m][cols];

        for (int i = 0; i < m; i++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                while (!dq.isEmpty() && ground[i][dq.peekLast()] >= ground[i][j]) {
                    dq.pollLast();
                }
                dq.addLast(j);

                while (!dq.isEmpty() && dq.peekFirst() <= j - w) {
                    dq.pollFirst();
                }

                if (j >= w - 1) {
                    rowMin[i][j - w + 1] = ground[i][dq.peekFirst()];
                }
            }
        }

        int[][] finalMin = new int[rows][cols];

        for (int j = 0; j < cols; j++) {
            Deque<Integer> dq = new ArrayDeque<>();
            for (int i = 0; i < m; i++) {
                while (!dq.isEmpty() && rowMin[dq.peekLast()][j] >= rowMin[i][j]) {
                    dq.pollLast();
                }
                dq.addLast(i);

                while (!dq.isEmpty() && dq.peekFirst() <= i - h) {
                    dq.pollFirst();
                }

                if (i >= h - 1) {
                    int topRow = i - h + 1;
                    finalMin[topRow][j] = rowMin[dq.peekFirst()][j];
                }
            }
        }

        int best = -1;
        int[] answer = {0, 0};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (finalMin[i][j] == Integer.MAX_VALUE) {
                    return new int[]{i, j};
                }

                if (finalMin[i][j] > best) {
                    best = finalMin[i][j];
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        return answer;
    }
}