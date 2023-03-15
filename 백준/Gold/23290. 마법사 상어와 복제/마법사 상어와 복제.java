import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	private static class Room{
		public ArrayDeque<Integer> fish;
		public int smell;
		public int fishSize;
		
		public Room() {
			this.fish = new ArrayDeque<Integer>();
			this.smell = 0;
			fishSize = 0;
		}
	}
	
	private static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1};
	private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	private static int[] ddy = {-1, 0, 1, 0};
	private static int[] ddx = {0, -1, 0, 1};
	private static int M, S, sy, sx;
	private static Room[][] map;
	private static int maxFish, path;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(),  " ");
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		map = new Room[4][4];
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) map[i][j] = new Room();
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken())-1;
			map[y][x].fish.offer(d);
		}
		st = new StringTokenizer(br.readLine(), " ");
		sy = Integer.parseInt(st.nextToken())-1;
		sx = Integer.parseInt(st.nextToken())-1;
		
		for(int s = 0; s < S; s++) {
			// 마법 시전!!
			ArrayDeque<int[]> cloneq = new ArrayDeque<>();
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					if(map[i][j].fish.size() == 0) continue;
					for(int f : map[i][j].fish) cloneq.offer(new int[] {i, j, f});
				}
			}
			
			// 물고기 이동!!
			ArrayDeque<int[]> moveq = new ArrayDeque<>();
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					if(map[i][j].fish.size() == 0) continue;
					while(!map[i][j].fish.isEmpty()) {
						int cur = map[i][j].fish.poll();
						int newy = i;
						int newx = j;
						for(int d = 8; d > 0; d--) {
							int ny = i+dy[(cur+d)%8];
							int nx = j+dx[(cur+d)%8];
							if(0 <= ny && ny < 4 && 0 <= nx && nx < 4
									&& !(ny == sy && nx == sx) && map[ny][nx].smell == 0) {
								newy = ny;
								newx = nx;
								cur = (cur+d)%8;
								break;
							}
						}
						moveq.offer(new int[] {newy, newx, cur});
					}
					map[i][j].fishSize = 0;
				}
			}
			while(!moveq.isEmpty()) {
				int[] cur = moveq.poll();
				map[cur[0]][cur[1]].fish.offer(cur[2]);
				map[cur[0]][cur[1]].fishSize++;
			}
			// 두 턴 전 냄새 사라짐!!
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					if(map[i][j].smell > 0) map[i][j].smell--;
				}
			}
			
			// 상어가 이동!!
			path = 0;
			maxFish = -1;
			dfs(sy, sx, 0, 0, 0);
			for(int i = 2; i >= 0; i--) {
				int mok = path/(int)Math.pow(10, i);
				int d = mok-1;
				sy += ddy[d];
				sx += ddx[d];
				if(map[sy][sx].fish.size() > 0) {
					map[sy][sx].fish.clear();
					map[sy][sx].fishSize = 0;
					map[sy][sx].smell = 2;
				}
				path -= mok*(int)Math.pow(10, i);
			}
			
			
			// 복제 물고기 등장!!
			while(!cloneq.isEmpty()) {
				int[] cur = cloneq.poll();
				map[cur[0]][cur[1]].fish.offer(cur[2]);
			}
		}
		int ans = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) ans += map[i][j].fish.size();
		}
		System.out.println(ans);
		br.close();
	}
	private static void dfs(int y, int x, int cnt, int fish, int visit) {
		if(cnt == 3) {
			if(maxFish < fish) {
				maxFish = fish;
				path = visit;
			}
			return;
		}
		for(int i = 0; i < 4; i++) {
			int newy = y+ddy[i];
			int newx = x+ddx[i];
			if(0 <= newy && newy < 4 && 0 <= newx && newx < 4) {
				int res = map[newy][newx].fishSize;
				map[newy][newx].fishSize = 0;
				dfs(newy, newx, cnt+1, fish+res, visit*10+(i+1));
				map[newy][newx].fishSize = res;
			}
		}
	}
}