import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static String[] words;
	private static boolean find;
	private static StringBuilder sb;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		words = new String[6];
		for(int i = 0; i < 6; i++) words[i] = br.readLine();
		perm(0, new int[3], new boolean[6]);
		System.out.println(find ? sb : 0);
		br.close();
	}
	
	private static void perm(int cnt, int[] sel, boolean[] v) {
		if(cnt == 3) {
			check(sel);
			return;
		}
		for(int i = 0; i < 6; i++) {
			if(v[i]) continue;
			v[i] = true;
			sel[cnt] = i;
			perm(cnt+1, sel, v);
			v[i] = false;
		}
	}
	
	private static void check(int[] sel) {
		int[] elses = new int[3];
		int idx = 0;
		for(int i = 0; i < 6; i++) {
			boolean isSel = false;
			for(int j = 0; j < 3; j++) {
				if(i == sel[j]) isSel = true;
			}
			if(!isSel) elses[idx++] = i;
		}
		
		char[][] puzzel = new char[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) puzzel[i][j] = words[sel[i]].charAt(j);
		}
		
		boolean[] used = new boolean[6];
		for(int i = 0; i < 3; i++) used[sel[i]] = true;
		
		for (int i = 0; i < 3; i++) {
			for (int k = 0; k < 3; k++) {
				if(used[elses[k]]) continue;
				boolean isRight = true;
				for (int j = 0; j < 3; j++) {
					if (puzzel[j][i] != words[elses[k]].charAt(j)) isRight = false;
				}
				if(isRight) {
					used[elses[k]] = true;
					break;
				}
			}
		}
		
		for(boolean b : used) if(!b) return;
		if(!find) {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) sb.append(puzzel[i][j]);
				sb.append("\n");
			}
		}
		find = true;
	}
}