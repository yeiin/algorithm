import java.util.*;

public class Main{

    public static void swap(char[][]board, int x, int y, int ax, int ay){
        char temp = board[x][y];
        board[x][y] = board[ax][ay];
        board[ax][ay] = temp;
    }
    
    public static int calculateCandies(char[] arr, int n){

        int max = 1;
        int tempMax = 1;

        for(int k=1; k<n; k++){
            if(arr[k]==arr[k-1]){
                tempMax += 1;
            }else{
                max = Math.max(max, tempMax);
                tempMax = 1;
            }
        }
        return Math.max(max, tempMax);
    
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        char[][] board = new char[n][n];

        int candy = 0;

        for(int i=0; i<n; i++){
            board[i] = sc.nextLine().toCharArray();
            
        }

        loop:
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
               
                if(j<n-1){
                    swap(board, i, j, i, j+1);

                    char[] arr1 = new char[n];
                    char[] arr2 = new char[n];
                    for(int k = 0;k<n; k++ ){
                        arr1[k] = board[k][j];
                        arr2[k] = board[k][j+1];
                    }

                    int count = Math.max(calculateCandies(arr1, n), calculateCandies(arr2, n));
                    count = Math.max(count,calculateCandies(board[i], n));
                    candy = Math.max(candy,count );    
                    swap(board, i, j, i, j+1);
                }

                if(i<n-1){
                    swap(board, i, j, i+1, j);
                    candy = Math.max(candy, Math.max(calculateCandies(board[i], n), calculateCandies(board[i+1], n)));    
                    swap(board, i, j, i+1, j);
                }

                if(candy == n){
                    break loop;
                }



            }
        }

        sc.close();
        System.out.println(candy);

    }
}