import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList[] g = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) g[i] = new ArrayList<int[]>();
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			g[s].add(new int[] {d, w});
			g[d].add(new int[] {s, w});
		}
		
		PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1],  o2[1]));
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[1] = 0;
		heap.offer(new int[] {1, 0});
		while(!heap.isEmpty()) {
			int[] cur = heap.poll();
			for(int[] nxt : (ArrayList<int[]>)g[cur[0]]) {
				if(dist[nxt[0]] > cur[1]+nxt[1]) {
					dist[nxt[0]] = cur[1]+nxt[1];
					heap.offer(new int[] {nxt[0], dist[nxt[0]]});
				}
			}
		}
		System.out.println(dist[N]);
		br.close();
	}
}