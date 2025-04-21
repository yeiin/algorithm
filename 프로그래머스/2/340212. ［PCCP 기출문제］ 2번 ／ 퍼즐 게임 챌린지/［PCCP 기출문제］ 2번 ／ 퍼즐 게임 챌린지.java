import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = Arrays.stream(diffs).max().getAsInt();
        int answer = right;

        while (left < right) {
            int mid = (left + right) / 2;
            long totalTime = times[0];

            for (int i = 1; i < diffs.length; i++) {
                
                if(diffs[i] > mid){
                    totalTime += (long)(diffs[i] - mid) * (times[i] +  times[i - 1]);
                }
                
                totalTime += times[i];
            }

            if (totalTime <= limit) {
                right = mid;
                answer = mid;
                
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}