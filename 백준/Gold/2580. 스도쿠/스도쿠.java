import java.io.*;
import java.util.*;

public class Main{

    static int[][] board = new int[9][9];
    static List<HashSet<Integer>> rows = new ArrayList<>();
    static List<HashSet<Integer>> columns = new ArrayList<>();
    static List<HashSet<Integer>> sections = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static boolean dfs(int i, int j){
        
        if(i==9){
            for(int x=0; x<9; x++){
                for(int y=0; y<9; y++){
                    sb.append(board[x][y]+" ");
                }
                sb.append("\n");
            }
            return true;
        }
        
        int nextI = (j == 8) ? i + 1 : i;
        int nextJ = (j == 8) ? 0 : j + 1;

        if (board[i][j] != 0) {
            return dfs(nextI, nextJ);
        }

        for(int x=1; x<=9; x++){
            if(!rows.get(i).contains(x) && !columns.get(j).contains(x) && !sections.get((i/3)*3 +(j/3)).contains(x)){
                rows.get(i).add(x);
                columns.get(j).add(x);
                sections.get((i/3)*3 +(j/3)).add(x);

                board[i][j] = x;

                if(j+1<9){
                    if(dfs(i, j+1)) return true;
                }else if(i+1<9){
                    if(dfs(i+1, 0)) return true;
                }else{
                   if(dfs(i+1, j+1)) return true;
                }
                board[i][j] = 0;
                rows.get(i).remove(x);
                columns.get(j).remove(x);
                sections.get((i/3)*3 +(j/3)).remove(x);
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i=0; i<9; i++){
            rows.add(new HashSet<>());
            columns.add(new HashSet<>());
            sections.add(new HashSet<>());
        
        }

        for(int i=0; i<9; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] != 0){
                    rows.get(i).add(board[i][j]);
                    columns.get(j).add(board[i][j]);
                    sections.get((i/3)*3 +(j/3)).add(board[i][j]);
                }
                
            }
        }

        dfs(0, 0);
    
        System.out.println(sb.toString());
    }
}