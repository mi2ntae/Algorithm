import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine() , " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList[] g = new ArrayList[N+1];
		int[] indegrees = new int[N+1];
		for(int i = 1; i <= N; i++) g[i] = new ArrayList<Integer>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			g[s].add(d);
			indegrees[d]++;
		}
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		for(int i = 1; i <= N; i++) {
			if(indegrees[i] == 0) q.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur+" ");
			for(int nxt : (ArrayList<Integer>)g[cur]) {
				if(--indegrees[nxt] == 0) q.offer(nxt);
			}
		}
		System.out.println(sb);
		br.close();
	}
}