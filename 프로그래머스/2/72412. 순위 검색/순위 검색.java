import java.util.*;

class Solution {
    
    HashMap<String, List<Integer>> map;
    
    public void makeMap(int index, String[] arr, String s){
        if(index == 4){
            if(!map.containsKey(s)) map.put(s, new ArrayList());
            map.get(s).add(Integer.parseInt(arr[4]));
            return;
        }
        makeMap(index+1, arr, s+arr[index]);
        makeMap(index+1, arr, s+"-");
    }
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        map = new HashMap();
        
        for(String i: info){
            String[] infoArr = i.split(" ");
            makeMap(0, infoArr, "");
        }
        
        for(List<Integer> list : map.values()) 
            Collections.sort(list);
        
        for(int i=0; i<query.length; i++){
            String tempQ = query[i].replace(" and ", "");
            String[] qArr = tempQ.split(" ");
            int score = Integer.parseInt(qArr[1]);
            
            if(!map.containsKey(qArr[0])) continue;
            
            List<Integer> list = map.get(qArr[0]);
            
            int start = 0;
            int end = list.size();

            while(start < end) { 
                int mid = (start + end) / 2;

                if(list.get(mid) >= score)
                    end = mid;
                else 
                    start = mid + 1;
            }

            answer[i] = list.size() - start;
            
        }
        
        return answer;
    }
}