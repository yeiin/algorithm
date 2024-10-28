import java.util.*;

public class Main{

    public static void main(String[] args){
        int[] heights = new int[9];
        int sum = 0;
        boolean end = false;
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<9; i++){
            heights[i] = sc.nextInt();
            sum += heights[i];
        }

        sc.close();

        for(int i=0; i<8; i++){
            for(int j=1; j<9; j++){
                if(sum - heights[i]-heights[j] == 100){
                    heights[i] = 0;
                    heights[j] = 0;
                    end = true;
                    break;
                }
            }
            if(end){
                break;
            }
        }
    
        Arrays.sort(heights);

        for(int num: heights){
            if(num != 0 ){
                System.out.println(num);
            }
        }

    }
}