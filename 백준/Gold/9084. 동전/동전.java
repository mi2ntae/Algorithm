import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			int[] coins = new int[N];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) coins[i] = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(br.readLine());
			
			int[] memo = new int[M+1];
			memo[0] = 1;
			for(int i = 0; i < N; i++) {
				for(int j = 1; j <= M; j++) {
					if(j < coins[i]) continue;
					memo[j] += memo[j-coins[i]];
				}
			}
			sb.append(memo[M]+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}