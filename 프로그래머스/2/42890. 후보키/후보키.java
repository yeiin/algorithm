import java.util.*;

class Solution {    
    
    List<int[]> list = new ArrayList();
    int[] arr;
    
    int m;
    
    public void makeList(){       
        for(int i=1; i<=m; i++){
            arr = new int[i];
            dfs(0, 0, i);
        }
    }
    
    public void dfs(int idx, int depth, int len){
        if(depth==len){
            list.add(arr.clone());
            return;
        }
        
        for(int i=idx; i<m; i++){
            arr[depth] = i;
            dfs(i+1, depth+1, len);
        }
    }
    
    public int solution(String[][] relation) {
        int answer = 0;
        this.m = relation[0].length;
        
        makeList();       
        List<Set<Integer>> cKeys = new ArrayList<>();
                
        for(int[] a: list){
            HashSet<String> set = new HashSet();    
            for(String[] r: relation){
                String temp = "";
                for(int i=0; i<a.length; i++){
                    if(temp.length()!=0) temp+="_";
                    temp += r[a[i]];
                }
                set.add(temp);
            }
            
            if(set.size() != relation.length) continue;
            
            Set<Integer> combSet = new HashSet<>();
            for (int b : a) combSet.add(b);
            
            boolean flag = true;
            for (Set<Integer> key : cKeys) {
                if (combSet.containsAll(key)) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) cKeys.add(combSet);
            
        }        
        
        return cKeys.size();
    }
}