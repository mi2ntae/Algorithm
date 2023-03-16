import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		int ans = 0;
		for(int i = 0; i < a.length()-b.length()+1;) {
			boolean appear = true;
			int cnt = 0;
			for(int j = 0; j < b.length(); j++) {
				if(a.charAt(i+j) != b.charAt(j)) {
					cnt = j;
					appear = false;
					break;
				}
				cnt++;
			}
			if(appear) {
				ans++;
				i += cnt;
			} else i++;
		}
		System.out.println(ans);
		br.close();
	}
}