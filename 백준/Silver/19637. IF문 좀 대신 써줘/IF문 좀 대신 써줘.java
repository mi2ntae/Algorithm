import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String[] ch = new String[N];
		int[] chn = new int[N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			ch[i] = st.nextToken();
			chn[i] = Integer.parseInt(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M; i++) {
			int k = Integer.parseInt(br.readLine());
			int beg = 0;
			int end = N-1;
			while(beg <= end) {
				int mid = (beg+end)/2;
				if(k <= chn[mid]) {
					end = mid-1;
				} else {
					beg = mid+1;
				}
			}
			sb.append(ch[beg]+"\n");
		}
		System.out.println(sb);
		br.close();
	}
}