import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] coins = new int[N];
		for(int i = 0; i < N; i++) coins[i] = Integer.parseInt(br.readLine());
		
		int[] memo = new int[K+1];
		Arrays.fill(memo, Integer.MAX_VALUE-1);
		memo[0] = 0;
		for(int i = 1; i <= K; i++) {
			for(int num : coins) {
				if(num > i) continue;
				memo[i] = Math.min(memo[i], memo[i-num]+1);
			}
		}
		System.out.println(memo[K] == Integer.MAX_VALUE-1 ? -1 : memo[K]);
		br.close();
	}
}