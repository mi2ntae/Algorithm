import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int mod = 1000000000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] memo = new int[N+1][10];
		
		for(int i = 1; i <= 9; i++) memo[1][i] = 1;
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j <= 9; j++) {
				if(j == 9) memo[i][j] = memo[i-1][j-1];
				else if(j == 0) memo[i][j] = memo[i-1][j+1];
				else memo[i][j] = (memo[i-1][(10+(j-1))%10]%mod + memo[i-1][(j+1)%10]%mod)%mod;
			}
		}
		
		int ans = 0;
		for(int i = 0; i <= 9; i++) ans = (ans + memo[N][i])%mod;
		System.out.println(ans);
		br.close();
	}
	
	
}