import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	private static int L, C;
	private static char[] a, b;
	private static char[] mo = {'a', 'e', 'i', 'o', 'u'};
	private static ArrayList<char[]> tmp;
	private static ArrayList<String> ans;
	private static StringBuilder sb;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		tmp = new ArrayList<>();
		ans = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		a = new char[C];
		b = new char[L];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < C; i++) a[i] = st.nextToken().charAt(0);
		comb(0, 0, 0, 0);
		
		for(char[] a : tmp) {
			Arrays.sort(a);
		ans.add(new String(a));
		}
		Collections.sort(ans);
		for(String a : ans) sb.append(a+"\n");
		System.out.println(sb);
	}
	private static void comb(int cnt, int start, int jaC, int moC) {
		if(cnt == L) {
			if(jaC >= 2 && moC >= 1) tmp.add(Arrays.copyOf(b, b.length));
			return;
		}
		for(int i = start; i < C; i++) {
			b[cnt] = a[i];
			boolean isMo = false;
			for(int k = 0; k < 5; k++) {
				if(a[i] == mo[k]) isMo = true;
			}
			if(isMo) comb(cnt+1, i+1, jaC, moC+1);
			else comb(cnt+1, i+1, jaC+1, moC);
		}
	}
}