import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashMap<String, String> map = new HashMap<>();

        List<Integer> numbers = new LinkedList<>();
        int tempSum = 0;

        for(int i=0; i<3; i++){
            int temp = Integer.parseInt(st.nextToken());
            numbers.add(temp);
            tempSum+=temp;
        }

        if(tempSum%3 !=0 ){
            System.out.println(0);
            return;
        }
        
        tempSum /= 3;

        while(!numbers.isEmpty()){
            
            if(numbers.size() == 0){
                System.out.println(1);
                return;
            }

            if(numbers.get(0)==tempSum){
                numbers.remove(0);
                continue;
            }

            int number1 = numbers.get(0);
            int number2 = numbers.get(1);

            if(number1 == number2){
                number2 = numbers.get(2);
                numbers.remove(2);   
            }else{
                numbers.remove(1);
            }
            numbers.remove(0);

            if(number1>number2){
                int t = number1;
                number1 = number2;
                number2 = t;
            }

            int x = number1;
            number1 += x;
            number2 -= x;

            if(map.containsKey(number1+","+number2)){
                System.out.println(0);
                return;
            }else{
                map.put(number1+","+number2, number1+","+number2);
            }

            if(number1<number2){
                if(number1!=tempSum) numbers.add(number1);
                if(number2!=tempSum) numbers.add(number2);
            }else{
                if(number2!=tempSum) numbers.add(number2);
                if(number1!=tempSum) numbers.add(number1);
            }
        }

        System.out.println(1);

    }
}