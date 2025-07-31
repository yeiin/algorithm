import java.util.*;

class Solution {
    
    public boolean isCorrect(String s){
        Stack<String> stack = new Stack();
        
        for(String c: s.split("")){
                       
            if(c.equals("(")) stack.push(c);
            else if(stack.isEmpty()) return false; 
            else stack.pop();
            
        }
        
        return true;
    }
    
    public String reverse(String u){
        String result="";
        
        if(u.length()==2) return result;
        u = u.substring(1, u.length()-1);
        
        for(String c: u.split("")){
            if(c.equals("(")) result+=")";
            else result+="(";
        }
        
        return result;
    }
    
    public String dfs(String s){
        if(s.length()==0) return s;
        
        String u = "";
        String v = "";
        
        int l = 0;
        int r = 0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='(') l++;
            else if(s.charAt(i)==')') r++;
            
            if(l==r){
                u = s.substring(0, i+1);
                v = s.substring(i+1);
                break;
            }
        }
        
        if(isCorrect(u)) return u + dfs(v);
        else return "(" + dfs(v) + ")" + reverse(u);
    }
    
    public String solution(String p) {
        
        return dfs(p);
    }
}