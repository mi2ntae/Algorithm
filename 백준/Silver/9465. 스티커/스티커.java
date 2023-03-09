import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[][] sticks = new int[2][N+1];
			for(int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 1; j <= N; j++) sticks[i][j] = Integer.parseInt(st.nextToken());
			}
			sticks[0][1] += sticks[1][0];
			sticks[1][1] += sticks[0][0];
			
			for(int i = 2; i <= N; i++) {
				for(int j = 0; j < 2; j++) sticks[j][i] += Math.max(sticks[(j+1)%2][i-1], sticks[(j+1)%2][i-2]);
			}
			sb.append(Math.max(sticks[0][N], sticks[1][N])).append("\n");
		}
		System.out.println(sb);
		br.close();
	}
}