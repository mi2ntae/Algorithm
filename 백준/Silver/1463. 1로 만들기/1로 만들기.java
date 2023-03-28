import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] memo = new int[N+1];
		Arrays.fill(memo, 1000001);
		memo[1] = 0;
		for(int i = 2; i <= N; i++) {
			if(i%3 == 0) memo[i] = Integer.min(memo[i], memo[i/3]+1);
			if(i%2 == 0) memo[i] = Integer.min(memo[i], memo[i/2]+1);
			memo[i] = Integer.min(memo[i], memo[i-1]+1);
		}
		System.out.println(memo[N]);
		br.close();
	}
}