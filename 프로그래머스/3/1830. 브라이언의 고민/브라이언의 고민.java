import java.util.*;

public class Solution {

    public String solution(String sentence) {
        List<String> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = sentence.toCharArray();
        
        String invalid = "invalid";

        // 소문자 등장 횟수 기록
        for (char c : arr) {
            if (Character.isLowerCase(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        
        int idx = 0;
        String temp = "";
        
        while(idx<sentence.length()){
            if(Character.isUpperCase(arr[idx])){ //대문자로 시작하는 경우
                
                if(idx == sentence.length()-1){
                    list.add(Character.toString(arr[idx]));
                    idx++;
                    continue;
                }
                //대문자+소문자: 규칙 1 확인
                if(Character.isLowerCase(arr[idx+1])){
                    temp+=arr[idx++];
                    while(idx<sentence.length()-1){
                        if(idx+2<sentence.length() && arr[idx+2]==arr[idx]){
                            temp+=arr[idx+1];
                            idx+=2;
                        }else{
                            temp += arr[idx+1];
                            list.add(temp);
                            temp = "";
                            idx+=2;
                            break;
                        }                   
                    }
                    
                    
                }else{ //대문자+대문자
                    while(idx<sentence.length() && Character.isUpperCase(arr[idx])){
                        temp+=arr[idx];
                        idx++;
                    }
                    list.add(temp);
                    temp = "";
                }
                
            }else { //소문자로 시작하는 경우
                if(map.get(arr[idx])!=2) return invalid;
                int ss = idx;
                idx++;
                while(idx<sentence.length()){
                    if(Character.isLowerCase(arr[idx]) && arr[ss] == arr[idx++]){
                        ss++; //대문자
                        String stemp = "";
                        if(Character.isLowerCase(arr[ss+1])){
                            stemp+=arr[ss++];
                            while(ss<idx-1){
                                if(ss+2<idx && arr[ss+2]==arr[ss]){
                                    stemp+=arr[ss+1];
                                    ss+=2;
                                }else{
                                    stemp += arr[ss+1];
                                    list.add(stemp);
                                    break;
                                }                   
                            }
                        }else{
                            list.add(temp);
                            temp = "";
                        }
                        break;
                    }
                    temp+=arr[idx];
                    idx++;
                }
                
            }
            
        }
        
        return String.join(" ", list);
    }
}