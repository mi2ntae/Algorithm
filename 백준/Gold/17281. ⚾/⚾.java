import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int N;
	private static int[] a;
	private static boolean[] v;
	private static int[][] scores;
	private static int ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		scores = new int[N][9];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < 9; j++) scores[i][j] = Integer.parseInt(st.nextToken());
		}
		a = new int[9];
		v = new boolean[9];
		a[3] = 0;
		perm(0);
		System.out.println(ans);
		br.close();
	}
	
	private static void perm(int cnt) {
		if(cnt == 9) {
			play();
			return;
		}
		if(cnt == 3) perm(cnt+1);
		else {
			for(int i = 1; i < 9; i++) {
				if(v[i]) continue;
				v[i] = true;
				a[cnt] = i;
				perm(cnt+1);
				v[i] = false;
			}
		}
	}
	
	private static void play() {
		int cnt = 0;
		boolean[] base = new boolean[3];
		int out = 0;
		int h = 0;
		int res = 0;
		while(cnt < N) {
			int score = scores[cnt][a[(h++)%9]];
			if(score == 0) {
				out++;
				if(out == 3) {
					out = 0;
					base = new boolean[3];
					cnt++;
				}
			} else if(score == 4) {
				for(int i = 0; i < 3; i++) {
					if(base[i]) {
						base[i] = false;
						res++;
					}
				}
				res++;
			} else {
				for(int i = 2; i >= 0; i--) {
					if(base[i]) {
						base[i] = false;
						if(i+score >= 3) res++;
						else base[i+score] = true;
					}
				}
				base[score-1] = true;
			}
		}
		ans = res > ans ? res : ans;
	}
}