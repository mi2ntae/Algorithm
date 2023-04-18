import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		int[][] c = new int[N][2];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			c[i][0] = Integer.parseInt(st.nextToken());
			c[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(c, (o1, o2) -> Integer.compare(o1[0], o2[0]));
		
		heap.offer(c[0][1]);
		int ans = 1;
		for(int i = 1; i < N; i++) {
			int s = c[i][0];
			int d = c[i][1];
			if(s >= heap.peek()) heap.poll();
			else ans++;
			heap.offer(d);
		}
		System.out.println(ans);
		br.close();
	}
}