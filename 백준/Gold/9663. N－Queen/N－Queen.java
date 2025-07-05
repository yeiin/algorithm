import java.util.*;

public class Main{

    static int answer = 0;
    static int n;

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    
    static int[] arr;


    public static boolean isFail(int col){
        for(int i=0; i<col; i++){
            if(arr[i]==arr[col]) return false;
            else if(Math.abs(col-i)==Math.abs(arr[col]-arr[i])) return false;
        }

        return true;
    }

    public static void dfs(int col, int depth){

        if(depth==n){
            answer++;
            return;
        }

        for(int j=0; j<n; j++){
            arr[col] = j; 
            if(isFail(col)){ 
                dfs(col+1, depth+1);
            }
        }

        return;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.close();

        arr = new int[n];

        dfs(0, 0);

        System.out.println(answer);

    }
}