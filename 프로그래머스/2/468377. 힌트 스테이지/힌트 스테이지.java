import java.util.*;

class Solution {
    int n;
    int[][] cost;
    int[][] hint;
    Map<String, Integer> map = new HashMap<>();

    public void apply(int[] hints, int[] bundle) {
        for (int i = 1; i < bundle.length; i++) {
            hints[bundle[i] - 1]++;
        }
    }

    public void rollback(int[] hints, int[] bundle) {
        for (int i = 1; i < bundle.length; i++) {
            hints[bundle[i] - 1]--;
        }
    }

    public String makeKey(int stage, int[] hints) {
        return stage + ":" + Arrays.toString(hints);
    }
    
    public int dfs(int stage, int[] hints) {
        if (stage == n) return 0;

        String key = makeKey(stage, hints);
        if (map.containsKey(key)) {
            return map.get(key);
        }

        int baseCost = cost[stage][Math.min(hints[stage], n-1)];

        if (stage == n-1) {
            map.put(key, baseCost);
            return baseCost;
        }

        int result = baseCost + dfs(stage+1, hints);

        apply(hints, hint[stage]);
        result = Math.min(result, baseCost + hint[stage][0] + dfs(stage+1, hints));
        rollback(hints, hint[stage]);

        map.put(key, result);
        
        return result;
    }
    
    public int solution(int[][] cost, int[][] hint) {
        this.n = cost.length;
        this.cost = cost;
        this.hint = hint;

        int[] hints = new int[n];
        return dfs(0, hints);
    }
    
    
}