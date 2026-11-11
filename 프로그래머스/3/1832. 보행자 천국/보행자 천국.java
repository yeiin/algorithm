import java.util.*;

class Solution {

    public int solution(int m, int n, int[][] cityMap) {
        final int MOD = 20170805;

        // 위에서 내려와서 이 칸에 도착하는 경로 수
        int[][] down = new int[m][n];

        // 왼쪽에서 오른쪽으로 와서 이 칸에 도착하는 경로 수
        int[][] right = new int[m][n];

        // 출발 경로 1개
        // 출발점이 0이므로 어느 배열에 넣어도 됨
        down[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (cityMap[i][j] == 1) continue;

                // 위 칸에서 내려오는 경우
                if (i > 0) {
                    if (cityMap[i - 1][j] == 2) {
                        // 위 칸이 직진 전용이면 아래 방향만 이어받음
                        down[i][j] = down[i - 1][j];
                    } else {
                        down[i][j] =
                            (down[i - 1][j] + right[i - 1][j]) % MOD;
                    }
                }

                // 왼쪽 칸에서 오른쪽으로 오는 경우
                if (j > 0) {
                    if (cityMap[i][j - 1] == 2) {
                        // 왼쪽 칸이 직진 전용이면 오른쪽 방향만 이어받음
                        right[i][j] = right[i][j - 1];
                    } else {
                        right[i][j] =
                            (down[i][j - 1] + right[i][j - 1]) % MOD;
                    }
                }
            }
        }

        return (down[m - 1][n - 1] + right[m - 1][n - 1]) % MOD;
    }
}