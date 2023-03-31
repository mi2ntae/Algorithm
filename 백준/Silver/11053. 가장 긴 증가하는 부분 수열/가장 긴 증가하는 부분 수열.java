import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
		
		int[] lis = new int[N];
		int size = 0;
		for(int k : nums) {
			int g = Arrays.binarySearch(lis, 0, size, k);
			if(g < 0) g = Math.abs(g)-1;
			lis[g] = k;
			if(g == size) size++;
		}
		System.out.println(size);
		br.close();
	}
}