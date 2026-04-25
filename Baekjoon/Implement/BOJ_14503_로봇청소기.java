package Search;

import java.io.*;
import java.util.StringTokenizer;

// 1. 로봇의 현재 위치, 바라보는 방향 + 방의 상태(0, 1) 저장
// 2. 방 청소 로직 구현

public class BOJ_14503_로봇청소기 {
	static final int[] dx = {-1, 0, 1, 0}; // 북0, 동1, 남2, 서3
	static final int[] dy = {0, 1, 0, -1};
	static int N, M, rX, rY, rD;
	static int[][] room;
	static int cleanCnt = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		rX = Integer.parseInt(st.nextToken()); // robot X 좌표
		rY = Integer.parseInt(st.nextToken()); // robot Y 좌표
		rD = Integer.parseInt(st.nextToken()); // robot 바라보는 방향(Direction) - 북0,동1,남2,서3
		
		room = new int[N][M]; // 방의 상태 - 벽1, 청소필요0
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				room[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			// [1] 현재 칸이 청소되지 않은 경우, 청소한다.
			if(room[rX][rY] == 0) {
				clean();
			}
			
			// [2] 현재 칸의 주변 칸 중 청소되지 않은 빈 칸이 있는 경우,
			boolean isDirty = searchDirty(); // true: 청소되지 않은 빈 칸 있음, false: 모두 청소됨 = 후진 필요
			if(isDirty) {
				clean();
			} else { // [3]
				// 바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진
				rX += dx[rD] * -1; rY += dy[rD] * -1;
				
				// 바라보는 방향의 뒤쪽 칸이 벽이라(혹은 범위 밖) 후진할 수 없다면 작동을 멈춘다.
				if(rX < 0 || rY < 0 || rX > N-1 || rY > M-1 || room[rX][rY] == 1) {
					System.out.println(cleanCnt);
					return;
				}
			}
		}
	}
	
	private static void clean() {
		room[rX][rY] = 2; // 청소됨2
		cleanCnt++;
	}
	
	// 현재 칸의 주변 칸 중 청소되지 않은 빈 칸을 찾는 함수
	private static boolean searchDirty() {
		for(int i=0; i<4; i++) {
			// 반시계 방향으로 90도 회전한다.
			rD = (rD + 3) % 4;
			// 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진
			rX += dx[rD]; rY += dy[rD];
			
			if(rX < 0 || rY < 0 || rX > N-1 || rY > M-1 || room[rX][rY] == 1) { // 전진한 칸이 벽이라면 (혹은 범위 밖)
				rX -= dx[rD]; rY -= dy[rD];
				continue;
			}
			
			if(room[rX][rY] == 0) {
				return true;
			} else {
				rX -= dx[rD]; rY -= dy[rD];
			}
		}
		return false;
	}
}
