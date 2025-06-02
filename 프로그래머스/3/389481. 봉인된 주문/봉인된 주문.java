import java.util.*;

class Solution {
    
    
    public long stringToNumber(String s){
        long digit = 1;
        long result = 0;
        
        char[] cArr = s.toCharArray();
        
        for(int i=cArr.length -1; i>=0; i--){
            result += (cArr[i] - 'a' + 1) * digit;
            digit *= 26;
        }
        
        return result;
    }
    
    public String numberToString(long number){
        long digit = 26;
        String result = "";
        
        while(number>0){
            
            int remain = (int)(number%digit);
            if(remain==0){
                remain = 26;
            }
            number = (number-remain)/digit;
            String remainString = Character.toString('a'+remain-1);
            result = remainString + result;
            
        }
        
        return result;
    }
    
    public String solution(long n, String[] bans) {
        
        Arrays.sort(bans, (a, b) -> {
            if (a.length() != b.length()) return Integer.compare(a.length(), b.length()); 
            return a.compareTo(b);});
        
        for(String ban: bans){
            long num = stringToNumber(ban);
            if(stringToNumber(ban) <= n){
                n++;
            }
        }
    
        String answer = numberToString(n);
        
        return answer;
    }
}