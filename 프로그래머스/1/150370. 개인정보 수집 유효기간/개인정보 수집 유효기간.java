import java.util.*;

class Solution {
    
    public boolean isExpired(int[] today, int[] expiredDate){
        if(today[0]<expiredDate[0]){
            return false;
        }else if(today[0]==expiredDate[0] && today[1] < expiredDate[1]){
            return false;
        }else if(today[0]==expiredDate[0] && today[1]==expiredDate[1] && today[2] <= expiredDate[2] ){
            return false;
        }
        
        return true;
    }
    
    public int[] expiredDate(int[] date, int term){
        date[2]--;
        date[1] += term;
        
        while(date[1]>12){
            date[0]++;
            date[1] -= 12;
        }
        
        return date;
    }
    
    public int[] dateToInt(String date){
        String[] dateList = date.split("\\.");        
        int[] dateInt = new int[3];
        
        for(int i=0; i<dateInt.length; i++){
            dateInt[i] = Integer.parseInt(dateList[i]);
        }
        
        return dateInt;
    }
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        HashMap<String, Integer> map = new HashMap();
        List<Integer> deleteList = new ArrayList();
        
        int[] todayInt = dateToInt(today);
        
        for(String term: terms){
            String[] tempTerm = term.split(" ");
            map.put(tempTerm[0], Integer.parseInt(tempTerm[1]));
        }
        
        for(int i=0; i<privacies.length; i++){
            String[] arr = privacies[i].split(" ");
            int[] date = expiredDate(dateToInt(arr[0]), map.get(arr[1]));
            
            if(isExpired(todayInt, date)) deleteList.add(i+1);
            
        }
        
        return deleteList.stream().mapToInt(Integer::intValue).toArray();
    }
}