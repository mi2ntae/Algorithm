import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		int ans = 0;
		int tmp = 0;
		boolean isMinus = false;
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) == '-' || a.charAt(i) == '+') {
				ans = isMinus ? ans-tmp : ans+tmp;
				tmp = 0;
				if(a.charAt(i) == '-') isMinus = true;
			} else {
				tmp *= 10;
				tmp += a.charAt(i)-'0';
			}
		}
		ans = isMinus ? ans-tmp : ans+tmp;
		System.out.println(ans);
		br.close();
	}
}