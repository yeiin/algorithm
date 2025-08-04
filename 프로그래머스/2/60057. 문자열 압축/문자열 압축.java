class Solution {
    public int solution(String s) {
        int answer = s.length();        
        
        for(int i=1; i<=s.length()/2; i++){
            StringBuilder compressed = new StringBuilder();
            String prev = s.substring(0, i);
            int count = 1;
            
            for (int j = i; j <= s.length(); j += i) {
                String next = s.substring(j, Math.min(j + i, s.length()));

                if (prev.equals(next)) {
                    count++;
                } else {
                    if (count > 1) compressed.append(count);
                    compressed.append(prev);
                    prev = next;
                    count = 1;
                    
                    if(j+i>s.length()){
                         compressed.append(s.substring(j));
                    }
                }
            }
                  
            answer = Math.min(answer, compressed.length());
        }
        return answer;
    }
}