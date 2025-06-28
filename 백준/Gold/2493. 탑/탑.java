import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		ArrayDeque<int[]> q = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		q.offer(new int[] {-1, 0});
		for(int i = 0 ; i < N; i++) q.offer(new int[] {i+1, Integer.parseInt(st.nextToken())});
		ArrayDeque<int[]> tmp = new ArrayDeque<>();
		int[] ans = new int[N+1];
		
		int size = q.size();
		while(size > 1) {
			int[] cur = q.pollLast();
			int[] after = q.peekLast();
			if(cur[1] > after[1]) tmp.offer(cur);
			else {
				while(!tmp.isEmpty()) {
					int[] tmpp = tmp.peekLast();
					if(tmpp[1] > after[1]) break;
					ans[tmpp[0]] = after[0];
					tmp.pollLast();
				}
				ans[cur[0]] = after[0];
			}
			size--;
		}
		for(int i = 1; i <= N; i++) sb.append(ans[i]+" ");
		System.out.println(sb);
		br.close();
	}
}
