import java.io.InputStreamReader;

import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] memo = new int[N+1];
		memo[1] = 1;
		if(N >= 2) {
			memo[2] = 3;
			for(int i = 3; i <= N; i++) memo[i] = memo[i-1]%10007 + (2*memo[i-2])%10007;
		}
		System.out.println(memo[N]%10007);
		br.close();
	}
}