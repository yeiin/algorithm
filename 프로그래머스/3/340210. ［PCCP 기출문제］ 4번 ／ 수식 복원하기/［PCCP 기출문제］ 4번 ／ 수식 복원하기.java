import java.util.*;

class Solution {
    
    public int calculate(int num1, int num2, String formula ){
        if(formula.equals("+")){
            return num1 + num2;
        }else{
            return num1 - num2;
        }
    }
    
    public int toDecimal(int offset, int number){
        int result = 0;
        int power = 1;
        
        while(number!=0){
            int digit = number % 10;
            if (digit >= offset) return -1; 
            result += digit * power;
            power *= offset;
            number /= 10;
        }
        
        return result;
    }
    
    public int decimalTo(int offset, int number){
        int result = 0;
        int base = 1;

        while (number > 0) {
            int digit = number % offset;
            result += digit * base;
            number /= offset;
            base *= 10; 
        }
        return result;
    }   
    
    
    
    public String[] solution(String[] expressions) {
        List<String> answerList = new LinkedList<>();
        List<String> problemList = new LinkedList<>();
        List<String> toSolveList = new LinkedList<>();
        List<Integer> offsets = new LinkedList(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9));
    
        for(String expression: expressions){
            String[] expressionArr = expression.split(" ");
            Set<Integer> deleteSet = new HashSet<>();
            
            for(String ex: expressionArr){
                if(ex.length()>=2 || ex.equals("+") || ex.equals("-") || ex.equals("=") || ex.equals("X")){
                    continue;
                }
                
                for(int i=0; i<offsets.size(); i++){
                    if(offsets.get(i) <= Integer.parseInt(ex)){
                        deleteSet.add(offsets.get(i));
                    }
                }
            }
                        

            if(expressionArr[4].equals("X")){
                problemList.add(expression);
                for(Integer offset: offsets){
                    int num1 = toDecimal(offset, Integer.parseInt(expressionArr[0]));
                    int num2 = toDecimal(offset, Integer.parseInt(expressionArr[2]));
                    if(num1==-1 || num2 == -1){
                        deleteSet.add(offset);
                    }
                }
                
            }else{
                for(Integer offset: offsets){
                    int num1 = toDecimal(offset, Integer.parseInt(expressionArr[0]));
                    int num2 = toDecimal(offset, Integer.parseInt(expressionArr[2]));
                    int num3 = toDecimal(offset, Integer.parseInt(expressionArr[4]));

                    if(num1==-1 || num2 == -1 ||num3 ==-1){
                        deleteSet.add(offset);
                        continue;
                    }
                    int tempResult = calculate(num1, num2, expressionArr[1]);
                    
                    if(tempResult != num3){
                        deleteSet.add(offset);
                    }
                }
            }
             
            offsets.removeIf(deleteSet::contains);
        }
                        
        for(String problem : problemList){
            String[] prblemArr = problem.split(" ");
            int result = -1;
            boolean flag = false;
            
            for(Integer offset: offsets){
                int num1 = toDecimal(offset, Integer.parseInt(prblemArr[0]));
                int num2 = toDecimal(offset,Integer.parseInt(prblemArr[2]));
                
                int tempResult = decimalTo(offset, calculate(num1, num2, prblemArr[1]));
                
                if (num1 == -1 || num2 == -1){
                    continue;
                }
                
                if(result == -1){
                    result = tempResult;
                }
                
                if(result != tempResult){
                    flag = true;
                    break;
                }
            }
            
            if(flag){
                prblemArr[4] = "?";
            }else{
                prblemArr[4] = Integer.toString(result);
            }
            answerList.add(String.join(" ", prblemArr));
        }
        
        
        return answerList.toArray(new String[0]);
    }
}