import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N <= 2) {
			System.out.println(1);
		} else {
			long[] memo = new long[N];
			memo[0] = 1;
			memo[1] = 1;
			for(int i = 2; i < N; i++) memo[i] = memo[i-1] + memo[i-2];
			System.out.println(memo[N-1]);
		}
		br.close();
	}
}