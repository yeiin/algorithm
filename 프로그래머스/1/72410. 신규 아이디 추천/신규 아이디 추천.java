class Solution {
    public String solution(String new_id) {        
        new_id = new_id.toLowerCase();
        new_id = new_id.replaceAll("[^0-9-_.a-z]","");
        new_id = new_id.replaceAll("\\.+",".");
        if(new_id.length() != 0 && new_id.charAt(0) == '.'){
            new_id = new_id.substring(1, new_id.length());
        }
        
        if(new_id.length() != 0 &&new_id.charAt(new_id.length()-1) == '.'){
            new_id = new_id.substring(0, new_id.length()-1);
        }
        
        if(new_id.length()==0) new_id = "a";
        if(new_id.length()>=16) new_id = new_id.substring(0, 15);
        
        if(new_id.length() != 0 &&new_id.charAt(new_id.length()-1) == '.'){
            new_id = new_id.substring(0, new_id.length()-1);
        }
        
        String next = new_id.substring(new_id.length()-1, new_id.length());
        
        while(new_id.length()<3){
            new_id+=next;
        }
        
        return new_id;
    }
}