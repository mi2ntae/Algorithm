import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] time = new int[N];
		for(int i = 0; i < N; i++) time[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(time);
		int res = 0;
		int ans = 0;
		for(int i = 0; i < N; i++) {
			res += time[i];
			ans += res;
		}
		System.out.println(ans);
		br.close();
	}
}