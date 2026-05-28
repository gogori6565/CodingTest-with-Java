package SEA;

import java.io.*;
import java.util.StringTokenizer;

public class SEA_D2_달팽이숫자 {
	static int[] dx = {0, 1, 0, -1}; // 우, 하, 좌, 상 (시계방향)
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			int num = 1;
			
			int[][] arr = new int[n][n];
			arr[0][0] = num++;
			
			for(int i=0; i<Math.ceil((double)n/2.0); i++) {
				int x = i;
				int y = i;
				
				for(int j=0; j<4; j++) {
					while(true) {
						x += dx[j];
						y += dy[j];
						
						if(x < 0 || x >= n) {
							x -= dx[j];
							break;
						} else if(y < 0 || y >= n) {
							y -= dy[j];
							break;
						}
						
						arr[x][y] = num++;
					}
				}
			}
			
			System.out.println("#" + test_case);
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr[i].length; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();
			}
		}
	}
}
