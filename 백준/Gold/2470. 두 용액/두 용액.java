import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) nums[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(nums);
		int i = 0;
		int j = nums.length-1;
		int res = Integer.MAX_VALUE;
		int ans1 = 0;
		int ans2 = 0;
		while(i < j) {
			int val = nums[i]+nums[j];
			if(res > Math.abs(val)) {
				ans1 = nums[i];
				ans2 = nums[j];
				res = Math.abs(val);
			}
			if(val > 0) j--;
			else i++;
		}
		sb.append(ans1+" "+ans2);
		System.out.println(sb);
		br.close();
	}
}