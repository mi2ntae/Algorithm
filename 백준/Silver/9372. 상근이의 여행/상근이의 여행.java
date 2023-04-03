import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			sb.append(Integer.parseInt(st.nextToken())-1+"\n");
			int M = Integer.parseInt(st.nextToken());
			for(int i = 0; i < M; i++) br.readLine();
		}
		System.out.println(sb);
		br.close();
	}
}