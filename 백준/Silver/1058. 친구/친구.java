import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		boolean[][] f = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			String a = br.readLine();
			for(int j = 0; j < N; j++) {
				if(a.charAt(j) == 'Y') f[i][j] = true;
			}
		}
		
		int ans = 0;
		for(int i = 0; i < N; i++) {
			int res = 0;
			boolean[] isF = new boolean[N];
			ArrayDeque<Integer> q = new ArrayDeque<>();
			isF[i] = true;
			for(int k = 0; k < N; k++) {
				if(!f[i][k]) continue;
				isF[k] = true;
				res++;
				q.offer(k);
			}
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				for(int k = 0; k < N; k++) {
					if(isF[k] || !f[cur][k]) continue;
					isF[k] = true;
					res++;
				}
			}
			ans = ans < res ? res : ans;
		}
		System.out.println(ans);
		br.close();
	}
}