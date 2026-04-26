package Search;

import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BOJ_14891_톱니바퀴 {
	static int[][] wheel;
	static int[] mid_point = {0, 0, 0, 0, 0}; // 12시를 가리키는 포인트의 인덱스 배열
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		wheel = new int[5][8];
		
		for(int i=1; i<5; i++) {
			String line = br.readLine();
			for(int j=0; j<8; j++) { // 12시방향부터 시계방향 순서대로 주어진다 - N극 0, S극 1
				wheel[i][j] = (int)line.charAt(j) - 48;
			}
		}
		
		int K = Integer.parseInt(br.readLine()); // 회전 횟수
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int wheel_number = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken()); // 시계방향 1, 반시계 방향 -1
			
			ArrayList<int[]> rotateWheel = samePoleWheel(wheel_number, direction);
			for(int[] wheel_direc_arr : rotateWheel) {
				changeMidPoint(wheel_direc_arr[0], wheel_direc_arr[1]);
			}
		}
		
		System.out.println(calculateScore());
	}
	
	// 맞닿는 부분의 극이 같아 돌아가는 톱니바퀴 찾기
	private static ArrayList<int[]> samePoleWheel(int wheel_number, int direction) {
		ArrayList<int[]> rotateWheel = new ArrayList<>();
		rotateWheel.add(new int[] {wheel_number, direction});
		
		int w = wheel_number;
		int d = direction;
		
		// 왼쪽 톱니바퀴
		while(true) {
			int now = w; // 비교 대상 번호
			int left = w - 1; // 오른쪽에 있는 바퀴 번호
			
			if(left < 1) break;
			
			int now_mid = (6 + mid_point[now]) % 8; // now 톱니바퀴의 맞닿는 부분 (초기 [2])
			int left_mid = (2 + mid_point[left]) % 8; // right 톱니바퀴의 맞닿는 부분 (초기 [6])
			
			if(wheel[now][now_mid] != wheel[left][left_mid]) {
				d *= -1;
				rotateWheel.add(new int[] {left, d});
			} else {
				break; // 안 돌면 그 너머도 안 돔
			}
			
			w--;
		}
		
		w = wheel_number;
		d = direction;
		
		// 오른쪽 톱니바퀴
		while(true) {
			int now = w; // 비교 대상 번호
			int right = w + 1; // 오른쪽에 있는 바퀴 번호
			
			if(right > 4) break;
			
			int now_mid = (2 + mid_point[now]) % 8; // now 톱니바퀴의 맞닿는 부분 (초기 [2])
			int right_mid = (6 + mid_point[right]) % 8; // right 톱니바퀴의 맞닿는 부분 (초기 [6])
			
			if(wheel[now][now_mid] != wheel[right][right_mid]) {
				d *= -1;
				rotateWheel.add(new int[] {right, d});
			} else {
				break; // 안 돌면 그 너머도 안 돔
			}
			
			w++;
		}
		
		return rotateWheel;
	}
	
	private static void changeMidPoint(int wheel_number, int direction) {
		if(direction == 1) { // 시계방향 1, 반시계 방향 -1
			mid_point[wheel_number] = (mid_point[wheel_number] + 7) % 8; // 시계방향
		} else {
			mid_point[wheel_number] = (mid_point[wheel_number] + 1) % 8; // 반시계방향
		}
	}
	
	private static int calculateScore() {
		int answer = 0;
		
		for(int i=1; i<mid_point.length; i++) {
			if(wheel[i][mid_point[i]] == 0) { // N극
				answer += 0;
			} else { // S극
				answer += Math.pow(2, i-1);
			}
		}
		
		return answer;
	}
}
