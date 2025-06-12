import java.util.*;
import java.io.*;

public class Main{
    
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        HashMap<String, Double> map = new HashMap<>();

        for(int i=0; i<n; i++){
            String[] temp = br.readLine().split("");
            for(int j=0; j<temp.length; j++){
                if(!map.containsKey(temp[j])){
                    map.put(temp[j], 0.0);
                }

                double num = map.get(temp[j]) + 1 * Math.pow(10, temp.length-j-1);
                map.put(temp[j], num);
            }
            

        }

        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        int number = 9;
        for(String key: keySet){
            answer += map.get(key) * number;
            number --;
        }

        System.out.println(answer);
        
    }
}