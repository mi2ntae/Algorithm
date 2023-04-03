import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = null;
			int[][] places = new int[N+2][2];
			for(int i = 0; i < N+2; i++) {
				st = new StringTokenizer(br.readLine());
				places[i][0] = Integer.parseInt(st.nextToken());
				places[i][1] = Integer.parseInt(st.nextToken());
			}
			boolean[][] isOkay = new boolean[N+2][N+2];
			for(int i = 0; i < N+2; i++) {
				for(int j = i+1; j < N+2; j++) {
					if(Math.abs(places[i][0]-places[j][0]) + Math.abs(places[i][1]-places[j][1]) <= 1000) {
						isOkay[i][j] = true;
						isOkay[j][i] = true;
					}
				}
			}
			
			boolean[] v = new boolean[N+2];
			ArrayDeque<Integer> q = new ArrayDeque<>();
			v[0] = true;
			q.offer(0);
			
			boolean ans = false;
			q : while(!q.isEmpty()) {
				int c = q.poll();
				for(int i = 0; i < N+2; i++) {
					if(v[i] || !isOkay[c][i]) continue;
					if(i == N+1) {
						ans = true;
						break q;
					}
					v[i] = true;
					q.offer(i);
				}
			}
			sb.append(ans ? "happy\n" : "sad\n");
		}
		System.out.println(sb);
		br.close();
	}
}