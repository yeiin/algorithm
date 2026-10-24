import java.util.*;

class Solution {
    
    public int[] stableDate (int[] arr){
        while(arr[1]>12){
            arr[0]++;
            arr[1]-=12;
        }
        return arr;
    }
    
    public int[] stringDateToInt(String s){
        String[] stringDate = s.split("\\.");
        int[] date = new int[stringDate.length];
        
        for(int i=0; i<stringDate.length; i++){
            date[i] = Integer.parseInt(stringDate[i]);
        }
        return date;
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answers = new ArrayList<>();

        int[] todayDate = stringDateToInt(today);
        
        HashMap<String, Integer> termsMap = new HashMap<>();
        for(String t: terms){
            String[] temp = t.split(" ");
            termsMap.put(temp[0], Integer.parseInt(temp[1]));
        }
        
        List<int[]> list = new ArrayList<>();
        for(String p: privacies){
            String[] arr = p.split(" ");
            int[] date = stringDateToInt(arr[0]);
            
            date[1] += termsMap.get(arr[1]);
            date = stableDate(date);
            list.add(date);
        }
        
        for(int i=0; i<list.size(); i++){
            int[] p = list.get(i);
                        
            if(p[0]<todayDate[0]){
                answers.add(i+1);
                continue;
            }else if(p[0]==todayDate[0] && p[1]<todayDate[1]){
                answers.add(i+1);
                continue;
            }else if(p[0]==todayDate[0] && p[1]==todayDate[1] && p[2]<=todayDate[2]){
                answers.add(i+1);
                continue;
            }
        }
        
        int[] answer = new int[answers.size()];
        for(int i=0; i<answers.size(); i++){
            answer[i] = answers.get(i);
        }

        
        return answer;
    }
}