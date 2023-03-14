import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int[] votes = new int[C];
		for(int i = 0; i < C; i++) votes[i] = Integer.parseInt(st.nextToken());
		
		boolean[] isOn = new boolean[101];
		int[] cnt = new int[101];
		int[] time = new int[101];
		
		for(int i = 0; i < C; i++) {
			int num = votes[i];
			if(isOn[num]) cnt[num]++;
			else {
				if (N > 0) {
					time[num] = i;
					cnt[num] = 1;
					isOn[num] = true;
					N--;
				} else {
					int min = 1001;
					int mink = -1;
					int mint = 1001;
					for(int k = 1; k < 101; k++) {
						if(isOn[k]) {
							if(cnt[k] == min) {
								if(time[k] < mint) {
									min = cnt[k];
									mink = k;
									mint = time[k];
								}
							} else if(cnt[k] < min) {
								min = cnt[k];
								mink = k;
								mint = time[k];
							}
						}
					}
					cnt[mink] = 0;
					time[mink] = 0;
					isOn[mink] = false;
					
					cnt[num] = 1;
					time[num] = i;
					isOn[num] = true;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < 101; i++) {
			if(isOn[i]) sb.append(i+" ");
		}
		System.out.println(sb);
		br.close();
	}
}