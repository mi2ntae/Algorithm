import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		
		int res = (int)(100.0*Y/X);
		long ans = 0;
		
		if(res == 99 || res == 100) {
			ans = -1;
		} else {
			long beg = 1;
			long end = Integer.MAX_VALUE;
			while(beg <= end) {
				long mid = (long)(beg+end)/2;
				if(res != (int)(100.0*(Y+mid)/(X+mid))) {
					end = mid-1;
					ans = mid;
				} else {
					beg = mid+1;
				}
			}
		}
		System.out.println(ans);
		br.close();
	}
}