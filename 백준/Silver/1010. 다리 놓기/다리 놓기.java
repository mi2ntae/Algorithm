import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] memo = new int[31][31];
			for(int i = 1; i <= M; i++) {
				memo[i][i] = 1;
				memo[i][0] = 1;
			}
			
			for(int i = 2; i <= M; i++) {
				for(int j = 1; j <= N; j++) {
					memo[i][j] = memo[i-1][j-1]+memo[i-1][j];
				}
			}
			sb.append(memo[M][N]+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}