import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int[] sushi = new int[N+k-1];
		for(int i = 0; i < N; i++) sushi[i] = Integer.parseInt(br.readLine());
		for(int i = 0; i < k-1; i++) sushi[N+i] = sushi[i];
		int[] eat = new int[d+1];
		int res = 0;
		int beg = 0;
		int end = k;
		
		eat[c]++;
		res++;
		for (int i = beg; i < end; i++) {
			if (eat[sushi[i]] == 0) res++;
			eat[sushi[i]]++;
		}
		int ans = res;
		while (end < N+k-1) {
			eat[sushi[beg]]--;
			if(eat[sushi[beg]] == 0) res--;
			beg++;
			if(eat[sushi[end]] == 0) res++;
			eat[sushi[end]]++;
			end++;
			if(eat[c] == 0) res++;
			ans = Math.max(ans, res);
		}
		System.out.println(ans);
		br.close();
	}
}