import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] ws = new int[N+1];
		int[] vs = new int[N+1];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			ws[i] = Integer.parseInt(st.nextToken());
			vs[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] memo = new int[N+1][K+1];
		for(int i = 1; i <= N; i++) {
			for(int k = 1; k <= K; k++) {
				if(ws[i] > k) memo[i][k] = memo[i-1][k];
				else memo[i][k] = Math.max(memo[i-1][k], memo[i-1][k-ws[i]] + vs[i]);
			}
		}
		System.out.println(memo[N][K]);
		br.close();
	}
}