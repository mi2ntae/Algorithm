import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[] munse = new int[N];
			ArrayDeque<Integer> q = new ArrayDeque<>();
			int imp = 0;
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				int k = Integer.parseInt(st.nextToken());
				if(i == M) {
					imp = k;
					q.offer(-1);
				} else q.offer(k);
				munse[i] = k;
			}

			Arrays.sort(munse);
			int p = munse.length-1;
			int ans = 0;
			while(!q.isEmpty()) {
				int cur = q.poll();
				if(cur == -1 && munse[p] == imp) break;
				if(cur == munse[p]) {
					p--;
					ans++;
				}
				else q.offer(cur);
			}
			sb.append(ans+1+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}