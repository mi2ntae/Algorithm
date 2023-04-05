import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int N, K;
	private static int[] nums;
	private static int size, start;
	private static int[] seg;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String a = br.readLine();
		while(a != null) {
			StringTokenizer st = new StringTokenizer(a, " ");
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			nums = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < N; i++) {
				int k = Integer.parseInt(st.nextToken());
				if(k == 0) nums[i] = 0;
				else if(k > 0) nums[i] = 1;
				else nums[i] = -1;
			}
			
			int g = 0;
			while(Math.pow(2, g) < N) g++;
			size = (int) Math.pow(2, g+1);
			start = (int) Math.pow(2, g);
			seg = new int[size];
			for(int i = 0; i < N; i++) seg[start+i] = nums[i];
			for(int i = start+N; i < size; i++) seg[i] = 1;
			for(int i = start-1; i > 0; i--) seg[i] = seg[i*2]*seg[i*2+1];
			
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String com = st.nextToken();
				if(com.charAt(0) == 'C') {
					int where = Integer.parseInt(st.nextToken())-1;
					int to = Integer.parseInt(st.nextToken());
					if(to == 0) to = 0;
					else if(to > 0) to = 1;
					else to = -1;
					change(start+where, to);
				} else {
					int s = Integer.parseInt(st.nextToken())-1;
					int d = Integer.parseInt(st.nextToken())-1;
					int res = find(1, start, size-1, start+s, start+d);
					if(res == 0) sb.append(0);
					else if(res < 0) sb.append("-");
					else sb.append("+");
				}
			}
			sb.append("\n");
			a = br.readLine();
		}
		System.out.println(sb);
		br.close();
	}
	
	private static void change(int where, int to) {
		seg[where] = to;
		for(int i = where/2; i > 0; i /= 2) seg[i] = seg[i*2]*seg[i*2+1];
	}
	private static int find(int num, int l, int r, int s, int d) {
		if(r < s || l > d) return 1;
		if(s <= l && r <= d) return seg[num];
		
		return find(num*2, l, (l+r)/2, s, d) 
				* find(num*2+1, (l+r)/2+1, r, s, d);
		
	}
}