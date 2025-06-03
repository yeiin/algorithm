import java.util.*;

class Solution {
    int[] result; 
    List<int[]> aDice = new ArrayList();
    List<Integer> as = new ArrayList();
    List<Integer> bs = new ArrayList();

    int n;
    int halfN;
    
    int[] arr;
    boolean[] visited;
    
    int[][] dice;
        
    void diceDfs(int index, int depth){
        if(depth == halfN){
            aDice.add(arr.clone());
            return;
        }
        
        for(int i=index; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                diceDfs(i, depth+1);
                visited[i] = false;
            }
        }
    }
    
    void dfs(boolean isA, int depth, int result, int[] picked){
        if(depth==halfN){
            if(isA){
                as.add(result);
            }else{
                bs.add(result);
            }
            return;
        }
        
        for(int i=0; i<6; i++){
            dfs(isA, depth+1, result + dice[picked[depth]][i], picked);
        }
    }
    
    
    int upperBound(List<Integer> list, int target){
        int left = 0, right = list.size();
        while(left < right){
            int mid = (left + right) / 2;
            if(list.get(mid) < target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    public int[] solution(int[][] dice) {
        int maxCount = 0;
        
        this.dice = dice;
        this.n = dice.length;
        this.halfN = (int) n/2;
            
        arr = new int[halfN];
        visited = new boolean[n];
        
        diceDfs(0,0);
        
        for(int[] d: aDice){
            
            
            Set<Integer> all = new HashSet<>();
            for(int i = 0; i < n; i++) all.add(i);

            Set<Integer> aSet = new HashSet<>();
            for(int i : d) aSet.add(i);

            Set<Integer> bSet = new HashSet<>(all);
            bSet.removeAll(aSet);

            int[] b = bSet.stream().mapToInt(Integer::intValue).toArray();
            
            
            as = new ArrayList();
            bs = new ArrayList();
            
            dfs(true, 0, 0, d);
            dfs(false, 0, 0, b);
            
            Collections.sort(bs);
            
            int winCount = 0;
            for(int aSum : as){
                int count = upperBound(bs, aSum);
                winCount += count;
            }

            if(winCount > maxCount){
                maxCount = winCount;
                result = d.clone();
            }
        
        }

        for(int i = 0; i < result.length; i++) result[i]++;
        return result;
    }
}