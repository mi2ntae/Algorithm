import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int[][] ways = new int[N][3];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			ways[i][0] = Integer.parseInt(st.nextToken());
			ways[i][1] = Integer.parseInt(st.nextToken());
			ways[i][2] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(ways, (o1, o2) -> Integer.compare(o1[1], o2[1]) == 0 ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));
		int[] dist = new int[D+1];
		for(int i = 0; i <= D; i++) dist[i] = i;
		
		for(int k = 1; k <= D; k++) {
			for(int i = 0; i < N; i++) {
				int s = ways[i][0];
				int d = ways[i][1];
				if(d > k) continue;
				int w = ways[i][2];
				if(k == d) {
					int tmp = Integer.min(dist[k-1]+1, dist[s]+w);
					dist[k] = Integer.min(dist[k], tmp);
				} else dist[k] = Integer.min(dist[k], dist[k-1]+1);
			}
		}
		System.out.println(dist[D]);
		br.close();
	}
}