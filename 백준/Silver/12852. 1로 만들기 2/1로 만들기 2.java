import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int[] memo;
	private static StringBuilder sb;
	private static int[] ans;
	private static int ansL = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		memo = new int[N+1];
		for(int i = 0; i <= N; i++) memo[i] = Integer.MAX_VALUE;
		int[] path = new int[N+1];
		ans = new int[N+1];
		dp(N, 0, path);
		sb.append(N+" ");
		for(int i = 0; i < ansL; i++) {
			sb.append(ans[i]+" ");
		}
		sb.insert(0, ansL+"\n");
		System.out.println(sb);
		br.close();
	}
	
	private static void dp(int n, int cnt, int[] path) {
		if(memo[n] < cnt) return;
		if(n <= 1) {
			if(cnt < ansL) {
				for(int i = 0; i < cnt; i++) ans[i] = path[i];
				ansL = cnt;
			}
			return;
		}
		if(n%3 == 0) {
			path[cnt] = n/3;
			memo[n/3] = Integer.min(memo[n/3], cnt+1);
			dp(n/3, cnt+1, path);
			path[cnt] = 0;
		}
		if(n%2 == 0) {
			path[cnt] = n/2;
			memo[n/2] = Integer.min(memo[n/2], cnt+1);
			dp(n/2, cnt+1, path);
			path[cnt] = 0;
		}
		path[cnt] = n-1;
		memo[n-1] = Integer.min(memo[n-1], cnt+1);
		dp(n-1, cnt+1, path);
		path[cnt] = 0;
	}
}