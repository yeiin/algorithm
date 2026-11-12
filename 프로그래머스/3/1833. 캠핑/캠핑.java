import java.util.*;


class Solution {
    public int solution(int n, int[][] data) {
        int answer = 0;
        
        // n개의 쐐기 중 한 쌍을 골라 텐트를 설치
            // 텐트는 직사각형이며, 네 면이 정확하게 동서남북 -> 높이, 너비가 서로 같아야 함.
            // 대각에 위치하는 텐트의 두 꼭지점이 두 개의 쐐기 위치
            // 0보다 큰 넒이 점유, 내부에 다른 쐐기 포함 금지 -> (a, b)(c,d) a<c, b !=d
        
        
        //x 기준 정렬
        Arrays.sort(data, (a,b) -> {
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        
        
       for (int i = 0; i < n; i++) {
           
           //탐색 노드의 x,y
           int baseX = data[i][0];
           int baseY = data[i][1];
           
           // 지금까지 만난 중간 쐐기 중 기준점보다 큰 가장 가까운 y, 가장 가까운 y
           int upper = Integer.MAX_VALUE;
            int lower = Integer.MIN_VALUE;
           
           
           int j = i + 1; // 현재 노드보다 큰 것을 기준으로 x 가 1이라도 더 큰 지점으로 

            while (j < n && data[j][0] == baseX) {
                j++;
            }

           // x(>baseX)인 index부터, 같은 x 값을 가진 end 까지 탐색
            while (j < n) {
                
                //j인덱스와 같은 x값을 가진 경계값
                int end = j;
                while (end < n && data[end][0] == data[j][0]) {
                    end++;
                }

                // 1. 현재 x에서 나올 수 있는 직사각형 검사
                // 같은 x를 가질 경우 경계에 머무르기 때문에 모두 count
                for (int k = j; k < end; k++) {
                    int y = data[k][1];

                    if (y > baseY && y <= upper) {
                        answer++;
                    } else if (y < baseY && y >= lower) {
                        answer++;
                    }
                }

                // 2. 다음 x를 검사할 때 사용할 내부 장애물 정보 갱신
                for (int k = j; k < end; k++) {
                    int y = data[k][1];

                    if (y > baseY) {
                        upper = Math.min(upper, y);
                    } else if (y < baseY) {
                        lower = Math.max(lower, y);
                    }
                }

                j = end;
            }
        }
            
        return answer;
    }
}