import java.util.*;

class Solution {
    
    public int[] decimalToBinary(long number){
        Stack<Integer> stack = new Stack();
        
        while(number>0){
            stack.push((int)(number%2));
            number /= 2;
        }
        
        int height = 1;
        int stackInt = stack.size();
        
        while(true){
            int nodeNum = ((int) Math.pow(2, height) - 1);
            if(stack.size() <= nodeNum) break;
            height ++;
        }
        
        int nodeNum = (int) Math.pow(2, height) - 1;
                               
        int[] binaryArr = new int[nodeNum];
        
        for(int i=nodeNum-stackInt; i<binaryArr.length; i++) 
            binaryArr[i] = stack.pop();
        
        return binaryArr;
        
    }
    
    public boolean isBinaryTree(int[] tree, int parentNode){
        
        if(tree.length == 1){
            if(tree[0]==1 && parentNode==0){
                return false;
            }
            return true;
        }
        
        int mid = tree.length/2;
        
        if(tree[mid]==1 && parentNode==0) return false;
         
        int[] left = Arrays.copyOfRange(tree, 0, mid);
        int[] right = Arrays.copyOfRange(tree, mid+1, tree.length);
        
        return isBinaryTree(left, tree[mid]) && isBinaryTree(right, tree[mid]);
    }
    
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            int[] binary = decimalToBinary(numbers[i]);
            
            if(isBinaryTree(binary, 1)) answer[i] = 1;
            else answer[i] = 0;
        }
        
        return answer;
    }
    
}