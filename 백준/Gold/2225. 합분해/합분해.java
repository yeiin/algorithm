import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[k+1][n+1];
		arr[0][0]=1;
		
		for(int i=1; i<k+1; i++) {
			for(int j=0; j<n+1; j++) {
				if(j-1>=0) {
					arr[i][j] = (arr[i][j-1]+arr[i-1][j])%1000000000;
				}else {
					arr[i][j] = arr[i-1][j]%1000000000;
				}
				
			}
		}
		
	
		
		System.out.println(arr[k][n]%1000000000);
	}

}