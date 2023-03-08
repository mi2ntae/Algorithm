import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, K;
	private static int[][] scores;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		scores = new int[K][2];
		for(int i = 0 ; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 2; j++) scores[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int[][] memo = new int[K+1][N+1];
		for(int i = 1; i <= K; i++) {
			for(int j = 1; j <= N; j++) {
				if(j < scores[i-1][1]) memo[i][j] = memo[i-1][j];
				else memo[i][j] = Math.max(memo[i-1][j], memo[i-1][j-scores[i-1][1]]+scores[i-1][0]);
			}
		}
		System.out.println(memo[K][N]);
		br.close();
	}
}