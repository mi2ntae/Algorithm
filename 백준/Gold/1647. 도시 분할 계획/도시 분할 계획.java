import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	private static int[] parents;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		PriorityQueue<int[]> heap = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2],  o2[2]));
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			heap.offer(new int[] {s, d, w});
		}
		
		parents = new int[N+1];
		for(int i = 1; i <= N; i++) parents[i] = i;
		int tmp = 0;
		int ans = 0;
		while(!heap.isEmpty()) {
			int[] cur = heap.poll();
			if(union(cur[0], cur[1])) {
				ans += cur[2];
				tmp = cur[2];
			}
		}
		System.out.println(ans-tmp);
		br.close();
	}
	
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa == pb) return false;
		parents[pb] = pa;
		return true;
	}
}