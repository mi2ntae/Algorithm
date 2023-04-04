import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String T = br.readLine();
		char[] t = new char[T.length()];
		for(int i = 0; i < T.length(); i++) t[i] = T.charAt(i);
		String P = br.readLine();
		char[] p = new char[P.length()];
		for(int i = 0; i < P.length(); i++) p[i] = P.charAt(i);
		
		int[] fail = new int[p.length];
		int j = 0;
		for (int i = 1; i < p.length; i++) {
			while (j > 0 && p[i] != p[j]) j = fail[j - 1];
			
			if (p[i] == p[j]) fail[i] = ++j;
			else fail[i] = 0;
		}
		
		int cnt = 0;
		j = 0;
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i = 0; i < t.length; i++) {
			while (j > 0 && t[i] != p[j]) j = fail[j - 1];
			if(t[i] == p[j]) {
				if (j == p.length-1) {
					cnt++;
					ans.add(i-j+1);
					j = fail[j];
				} else ++j;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(cnt+"\n");
		for(int a : ans) sb.append(a+" ");
		System.out.println(sb);
		br.close();
	}
}