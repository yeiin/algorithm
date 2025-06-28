class Solution {
    int n, m;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int[] dfs(int[][] board, int ax, int ay, int bx, int by) {
        
        if (board[ax][ay] == 0) return new int[]{0, 0};

        int win = 0;
        int minTurn = Integer.MAX_VALUE;
        int maxTurn = 0;

        for (int d = 0; d < 4; d++) {
            int nax = ax + dx[d];
            int nay = ay + dy[d];
            if (nax < 0 || nay < 0 || nax >= n || nay >= m || board[nax][nay] == 0) continue;

            board[ax][ay] = 0;
            int[] result = dfs(board, bx, by, nax, nay);
            board[ax][ay] = 1;

            if (result[0] == 0) {
                win = 1;
                minTurn = Math.min(minTurn, result[1]+1);
            } else if (win == 0) { 
                maxTurn = Math.max(maxTurn, result[1]+1);
            }
        }

        if (win == 1) return new int[]{1, minTurn};
        else return new int[]{0, maxTurn};
    }
    

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        n = board.length;
        m = board[0].length;
        return dfs(board, aloc[0], aloc[1], bloc[0], bloc[1])[1];
    }
}