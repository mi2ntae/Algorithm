import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	private static int[] dy = {-1 ,0, 1, 0};	// 위 ,왼, 아래, 오
	private static int[] dx = {0, -1, 0, 1};	// 위 ,왼, 아래, 오
	
	private static int[] ddy = {-1, -1, -1, 0, 0, 1, 1, 1};	// 8방향
	private static int[] ddx = {-1, 0, 1, -1, 1, -1, 0, 1};	// 8방향
	private static int N;
	private static int[][] map;	// 평지
	private static boolean[][][] v;	// 방문 배열 y, x, 기둥 방향
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		boolean bFind = false;	// 기둥 가운데를 찾기 위한 변수
		int befB = 0;	// 이전에 등장한 기둥의 y좌표
		int by = 0;		// 기둥 가운데 좌표
		int bx = 0;		// 기둥 가운데 좌표
		int bStand = 0;	// 기둥 상태 (가로 : 0, 세로 : 1)
		boolean eFind = false;	// 목적지 가운데를 찾기 위한 변수
		int befE = 0;	// 이전에 등장한 목적지 y좌표
		int ey = 0;		// 목적지 가운데 y좌표
		int ex = 0;		// 목적지 가운데 ㅌ좌표
		int eStand = 0;	// 목적지 상태 (가로 : 0, 세로 : 1)
		for(int i = 0; i < N; i++) {	// map 채우기
			String a = br.readLine();
			for(int j = 0; j < a.length(); j++) {
				char k = a.charAt(j);
				if(k == '1') map[i][j] = 1;		// '1'이라면 1채우기
				else {							
					map[i][j] = 0;				// 그 외의 경우 0으로 채우기
					if(k == 'B') {			// B를 발견
						if(bFind) {			// 이전에 B를 발견 했었다면
							by = i;			
							bx = j;
							if(by == befB) bStand = 0;	// 이전에 발견한 B의 y좌표가 현재B의 y좌표와 같다면 기둥 방향은 가로
							else bStand = 1;			// 아니라면 기둥 방향은 세로
							bFind = false;
						} else {			// 처음으로 B를 발견한 경우
							befB = i;		// B 가운데를 찾기 위해 y좌표 저장
							bFind = true;
						}
					} else if(k == 'E') {	// E를 발견
						if(eFind) {			// 이전에 E를 발견 했었다면
							ey = i;
							ex = j;
							if(ey == befE) eStand = 0;	// 이전에 발견한 E의 y좌표가 현재E의 y좌표와 같다면 목적지 방향은 가로
							else eStand = 1;			// 아니라면 목적지 방향은 세로
							eFind = false;
						} else {			// 처음으로 E를 발견한 경우
							befE = i;		// E 가운데를 찾기 위해 y좌표 저장
							eFind = true;
						}
					} 
				}
			}
		}
		
		int ans = 0;
		ArrayDeque<int[]> q = new ArrayDeque<>();	// BFS를 위한 큐
		v = new boolean[N][N][2];	// 방문 배열 (y, x, 기둥 방향)
		
		v[by][bx][bStand] = true;	// 현재 기둥의 가운데 좌표, 현재 기둥의 방향
		q.offer(new int[] {by, bx, bStand, 0});
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			int cy = cur[0];
			int cx = cur[1];
			int cS = cur[2];
			int cnt = cur[3];
			if(cy == ey && cx == ex && cS == eStand) {	// 현재 기둥의 가운데 좌표가 목적지와 같고 방향까지 같은 경우 정답 찾음
				ans = cnt;
				break;
			}
			for (int d = 0; d < 4; d++) {	// 위, 왼, 아래, 오
				int ny = cy + dy[d];
				int nx = cx + dx[d];
				if (d % 2 == 0) { 	// 위 or 아래
					if (cS == 0) { 		// 기둥이 가로로 누워있는 경우
						if (isHorizUDOkay(ny, nx, cS)) {
							v[ny][nx][cS] = true;
							q.offer(new int[] { ny, nx, cS, cnt+1});
						}
					} else { 			// 기둥이 세로로 서 있는 경우
						if (isVertUDOkay(ny, nx, cS)) {
							v[ny][nx][cS] = true;
							q.offer(new int[] { ny, nx, cS, cnt+1});
						}
					}
				} else { 			// 왼 or 오
					if (cS == 0) { 		// 기둥이 가로로 누워있는 경우
						if (isHorizLROkay(ny, nx, cS)) {
							v[ny][nx][cS] = true;
							q.offer(new int[] { ny, nx, cS, cnt+1});
						}
					} else { 			// 기둥이 세로로 서 있는 경우
						if (isVertLROkay(ny, nx, cS)) {
							v[ny][nx][cS] = true;
							q.offer(new int[] { ny, nx, cS, cnt+1});
						}
					}
				}
			}
			boolean canSpin = true;	// 방향을 돌릴 수 있는지 여부
			for(int d = 0; d < 8; d++) {	// 8방향 확인
				int ny = cy+ddy[d];
				int nx = cx+ddx[d];
				if(ny < 0 || ny >= N || nx < 0 || nx >= N || map[ny][nx] == 1) canSpin = false;	// 범위 밖이거나, 1이 있는 경우
			}
			int nS = (cS+1)%2;	// 바뀔 방향
			if(canSpin && !v[cy][cx][nS]) {	// 돌릴 수 있고, 돌린 이후의 상태를 방문하지 않은 경우
				v[cy][cx][nS] = true;
				q.offer(new int[] {cy, cx, nS, cnt+1});
			}
		}
		System.out.println(ans);
		br.close();
	}
	
	// 가로 기둥을 위, 아래로 움직이는 경우
	private static boolean isHorizUDOkay(int y, int x, int stand) {
		if(0 <= y && y < N) {
			if (map[y][x-1] != 1 && map[y][x] != 1 && map[y][x+1] != 1) {
				if (!v[y][x][stand]) return true;
			}
		}
		return false;
	}
	// 가로 기둥을 좌, 우로 움직이는 경우
	private static boolean isHorizLROkay(int y, int x, int stand) {
		if(0 <= x-1 && x-1 < N && 0 <= x+1 && x+1 < N) {
			if (map[y][x-1] != 1 && map[y][x + 1] != 1) {
				if (!v[y][x][stand]) return true;
			}
		}
		return false;
	}
	// 세로 기둥을 위, 아래로 움직이는 경우
	private static boolean isVertUDOkay(int y, int x, int stand) {
		if(0 <= y-1 && y-1 < N && 0 <= y+1 && y+1 < N) {
			if(map[y-1][x] != 1 && map[y+1][x] != 1) {
				if(!v[y][x][stand]) return true;
			}
		}
		return false;
	}
	// 세로 기둥을 좌, 우로 움직이는 경우
	private static boolean isVertLROkay(int y, int x, int stand) {
		if(0 <= x && x < N) {
			if (map[y-1][x] != 1 && map[y][x] != 1 && map[y+1][x] != 1) {
				if (!v[y][x][stand]) return true;
			}
		}
		return false;
	}
}