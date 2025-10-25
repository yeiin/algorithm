import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        HashMap<String, Integer> idMap = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        
        for(String id: id_list){
            int num = idMap.size();
            idMap.put(id, num);
            map.put(num, new HashSet<>());
        }
        
        
        for(String r: report){
            String[] rArr = r.split(" ");
            int lUserIdx = idMap.get(rArr[0]);
            int rUserIdx = idMap.get(rArr[1]);
            map.get(rUserIdx).add(lUserIdx);
        }
        
        for(int i: map.keySet()){
            if(map.get(i).size()>=k){
                Iterator<Integer> iter = map.get(i).iterator();
                while(iter.hasNext())
                {
                    answer[iter.next()] ++;
                }
            }
        }
        
        return answer;
    }
}