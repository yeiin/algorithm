import java.util.*;

class Solution {
    int n, m;
    Deque<Integer> fCol,lCol;
    LinkedList<Deque<Integer>> rows;

    public void rotate() {
        if (m==2) {
            lCol.addFirst(fCol.pollFirst());
            fCol.addLast(lCol.pollLast());
            return;
        }
        rows.peekFirst().addFirst(fCol.pollFirst());
        lCol.addFirst(rows.peekFirst().pollLast());
        rows.peekLast().addLast(lCol.pollLast());
        fCol.addLast(rows.peekLast().pollFirst());
    }

    public void shiftRow() {
        rows.addFirst(rows.pollLast());
        fCol.addFirst(fCol.pollLast());
        lCol.addFirst(lCol.pollLast());
    }

    public int[][] solution(int[][] rc, String[] operations) {
        n = rc.length;
        m = rc[0].length;

        fCol = new ArrayDeque<>();
        lCol = new ArrayDeque<>();
        
        for (int i=0; i<n; i++) {
            fCol.add(rc[i][0]);
            lCol.add(rc[i][m-1]);
        }

        rows = new LinkedList<>();
        for (int i=0; i<n; i++) {
            Deque<Integer> temp = new ArrayDeque<>();
            for (int j=1; j<m-1; j++) {
                temp.add(rc[i][j]);
            }
            rows.add(temp);
        }
        
        for (String oper : operations) {
            switch (oper) {
                case "Rotate":
                    rotate();    
                    break;
                case "ShiftRow":
                    shiftRow();  
                    break;
            }
        }
        
        int[][] answer = new int[n][m];
        for (int i = 0; i < n; i++) {
            answer[i][0] = fCol.pollFirst();
            answer[i][m-1] = lCol.pollFirst();
        }
        int i = 0;
        for (Deque<Integer> row: rows) {
            for (int j = 1; j < m-1; j++) {
                answer[i][j] = row.pollFirst();
            }
            i++;
        }
        
        return answer;
    }
}