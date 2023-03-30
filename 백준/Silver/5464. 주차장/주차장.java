import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] costs = new int[N];
		for(int i = 0; i < N; i++) costs[i] = Integer.parseInt(br.readLine());
		int[] cars = new int[M+1];
		for(int i = 1; i <= M; i++) cars[i] = Integer.parseInt(br.readLine());
		
		boolean[] parks = new boolean[N];
		int[] carPark = new int[M+1];
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		int ans = 0;
		for(int i = 0; i < 2*M; i++) {
			int k = Integer.parseInt(br.readLine());
			if(k < 0) {
				k *= -1;
				parks[carPark[k]] = false;
			} else q.offer(k);
			
			
			if(q.size() > 0) {
				for(int j = 0; j < N; j++) {
					if(parks[j]) continue;
					parks[j] = true;
					int car = q.poll();
					carPark[car] = j;
					ans += costs[j] * cars[car];
					break;
				}
			}
		}
		System.out.println(ans);
		br.close();

	}

}