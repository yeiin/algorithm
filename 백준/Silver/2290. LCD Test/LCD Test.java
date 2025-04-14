import java.util.*;
import java.io.*;

public class Main{
    static int s;
    static String n;
    static char[][] results;

    public static void horizontal(int row, int start){

        for(int i=start; i<start+s; i++){
            results[row][i] = '-';
        }
    }

    public static void vertical(int col, int start){
        for(int i=start; i<start+s; i++){
            results[i][col] = '|';
        }
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        n = st.nextToken();

        int height = 2*s+3;
        int width = (s+2) * n.length() + (n.length()-1);

        results = new char[height][width];

        for(int i=0; i<height; i++){
            Arrays.fill(results[i], ' ');
        }
        

        for(int i=0; i<n.length(); i++){
            int start = i*(s+3);
            switch (n.charAt(i)) {
                case '0':
                    horizontal(0, start+1);
                    horizontal(2*s+2, start+1);
                    vertical(start, 1);
                    vertical(start, s+2);
                    vertical(start+s+1, 1);
                    vertical(start+s+1, s+2);
                    break;
                case '1':
                    vertical(start+s+1, 1);
                    vertical(start+s+1, s+2);
                    break;
                case '2':
                    horizontal(0, start+1);
                    horizontal(s+1, start+1);
                    horizontal(2*s+2, start+1);
                    vertical(start+s+1, 1);
                    vertical(start, s+2);
                    break;
                case '3':
                    horizontal(0, start+1);
                    horizontal(s+1, start+1);
                    horizontal(2*s+2, start+1);
                    vertical(start+s+1, 1);
                    vertical(start+s+1, s+2);
                    break;
                case '4':
                    horizontal(s+1, start+1);
                    vertical(start, 1);

                    vertical(start+s+1, 1);
                    vertical(start+s+1, s+2);
                    break;
                case '5':
                    horizontal(0, start+1);
                    horizontal(s+1, start+1);
                    horizontal(2*s+2, start+1);
                    vertical(start, 1);
                    vertical(start+s+1, s+2);
                    break;
                case '6':
                    horizontal(0, start+1);
                    horizontal(s+1, start+1);
                    horizontal(2*s+2, start+1);
                    vertical(start, 1);
                    vertical(start, s+2);
                    vertical(start+s+1, s+2);
                    break;
                case '7':
                    horizontal(0, start+1);
                    vertical(start+s+1, 1);
                    vertical(start+s+1, s+2);
                    break;
                case '8':
                    horizontal(0, start+1);
                    horizontal(s+1, start+1);
                    horizontal(2*s+2, start+1);
                    vertical(start, 1);
                    vertical(start, s+2);
                    vertical(start+s+1, 1);
                    vertical(start+s+1, s+2);
                    break;
                case '9':
                    horizontal(0, start+1);
                    horizontal(s+1, start+1);
                    horizontal(2*s+2, start+1);
                    vertical(start, 1);
                    vertical(start+s+1, 1);
                    vertical(start+s+1, s+2);
                    break;

                default:
                    break;

            }
            

        }

        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                System.out.print(results[i][j]);
            }
            System.out.println();
        }
    }


}