import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int L = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		char[] t = S.toCharArray();
		int[] fail = new int[L];
		int j = 0;
		for(int i = 1; i < L; i++) {
			while(j > 0 && t[i] != t[j]) j = fail[j-1];
			
			if(t[i] == t[j]) fail[i] = ++j;
			else fail[i] = 0;
		}
		System.out.println(L-fail[L-1]);
		br.close();
	}
}