import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Map<String, Boolean> map = new HashMap<>();
		for(int i = 0; i < N; i++) map.put(br.readLine(), true);
		int ans = 0;
		for(int i = 0; i < M; i++) {
			if(map.containsKey(br.readLine())) ans++;
		}
		System.out.println(ans);
		br.close();
	}
	
}