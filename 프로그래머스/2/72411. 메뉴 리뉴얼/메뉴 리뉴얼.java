import java.util.*;

class Solution {
    HashMap<String, Integer> orderMap = new HashMap();
    String[] orderArr;
    int goalDepth;
    boolean[] visited;
    
    public void searchCourse(int idx, int depth, String result){
        
        if(depth == goalDepth){
            if(!orderMap.containsKey(result)) orderMap.put(result, 1);
            else orderMap.put(result, orderMap.get(result)+1);
            return;
        }
        
        for(int i = idx; i<orderArr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                searchCourse(i, depth+1, result+orderArr[i]);
                visited[i] = false;
            }
        }
        
    }
    
    public String[] solution(String[] orders, int[] course) {
        for(String order: orders){
            orderArr = order.split("");
            Arrays.sort(orderArr);
            visited = new boolean[orderArr.length];
            
            for(int c: course){
                if(c>order.length()) break;
                goalDepth = c;
                searchCourse(0, 0, "");
            }  
        }
        
        List<String> answers = new LinkedList();        
        for(String key: orderMap.keySet()){
            if(orderMap.get(key)>=2) answers.add(key);
        }
        Collections.sort(answers, (o1,o2)->{
            if(o1.length()==o2.length()){
                if(orderMap.get(o1) == orderMap.get(o2)){
                    return o1.compareTo(o2);
                }else{
                    return orderMap.get(o2) - orderMap.get(o1);
                }   
            }else{
                return o1.length() - o2.length();
            }
        });
        
        List<String> answer = new ArrayList();
        int[] maxNum = new int[11];
        
        for(String a: answers){
            if(maxNum[a.length()] <= orderMap.get(a)){
                maxNum[a.length()] = orderMap.get(a);
                answer.add(a);
            }
        }
        Collections.sort(answer);
        
        return answer.toArray(new String[0]);
    }
}