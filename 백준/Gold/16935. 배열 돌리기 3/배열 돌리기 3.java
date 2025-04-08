import java.util.*;
import java.io.*;

public class Main{

    static int n;
    static int m;

    public static int[][] cal1(int[][] arr1){
        int[][] arr2 = new int[n][m];
        for(int i=0; i<n; i++){
            arr2[i] = arr1[n-1-i];
        }
        return arr2;
    }

    public static int[][] cal2(int[][] arr1){
        int[][] arr2 = new int[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr2[i][j] = arr1[i][m-1-j];
            }
        }
        return arr2;
    }

    public static int[][] cal3(int[][] arr1){
        int[][] arr2 = new int[m][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
               arr2[j][n-1-i] = arr1[i][j];
            }
        }

        int temp = n;
        n = m;
        m = temp;

        return arr2;
    }

    public static int[][] cal4(int[][] arr1){
        int[][] arr2 = new int[m][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                arr2[m - 1 - j][i] = arr1[i][j];
            }
        }
        int temp = n;
        n = m;
        m = temp;
        
        return arr2;

    }

    public static int[][] cal5(int[][] arr1){
        int[][] arr2 = new int[n][m];
        int n2 = n / 2;
        int m2 = m / 2;

        for(int i=0; i<n2; i++){
            for(int j=0; j<m2; j++){
                arr2[i][j + m2] = arr1[i][j]; 
            }
        }
        for(int i=0; i<n2; i++){
            for(int j=m2; j<m; j++){
                arr2[i + n2][j] = arr1[i][j]; 
            }
        }
        for(int i=n2; i<n; i++){
            for(int j=m2; j<m; j++){
                arr2[i][j - m2] = arr1[i][j]; 
            }
        }
        for(int i=n2; i<n; i++){
            for(int j=0; j<m2; j++){
                arr2[i - n2][j] = arr1[i][j]; 
            }
        }
        return arr2;

    }

    public static int[][] cal6(int[][] arr1){
        int[][] arr2 = new int[n][m];
        int n2 = n / 2;
        int m2 = m / 2;

        for(int i=0; i<n2; i++){
            for(int j=0; j<m2; j++){
                arr2[i + n2][j] = arr1[i][j]; 
            }
        }
        for(int i=n2; i<n; i++){
            for(int j=0; j<m2; j++){
                arr2[i][j + m2] = arr1[i][j]; 
            }
        }
        for(int i=n2; i<n; i++){
            for(int j=m2; j<m; j++){
                arr2[i - n2][j] = arr1[i][j]; 
            }
        }
        for(int i=0; i<n2; i++){
            for(int j=m2; j<m; j++){
                arr2[i][j - m2] = arr1[i][j]; 
            }
        }
        return arr2;

    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int[] calArr = new int[r];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<r; i++){
            calArr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<r; i++){
            if(calArr[i]==1){
                arr = cal1(arr);
            }else if(calArr[i]==2){
                arr = cal2(arr);
            }else if(calArr[i]==3){
                arr = cal3(arr);
            }else if(calArr[i]==4){
                arr = cal4(arr);
            }else if(calArr[i]==5){
                arr = cal5(arr);
            }else if(calArr[i]==6){
                arr = cal6(arr);
            }
        }

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}