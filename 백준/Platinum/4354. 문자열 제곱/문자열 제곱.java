import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String a = br.readLine();
		while(!a.equals(".")) {
			char[] t = a.toCharArray();
			int[] fail = new int[t.length];
			int j = 0;
			for(int i = 1; i < t.length; i++) {
				while(j > 0 && t[i] != t[j]) j = fail[j-1];
				
				if(t[i] == t[j]) fail[i] = ++j;
				else fail[i] = 0;
			}
			
			if(t.length%(t.length-fail[t.length-1]) == 0) sb.append(t.length/(t.length-fail[t.length-1])+"\n");
			else sb.append(1+"\n");
			a = br.readLine();
		}
		System.out.println(sb);
		br.close();
	}
}