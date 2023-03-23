import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static long[] sTree;
	private static int start;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int dep = 0;
		while(Math.pow(2, dep) < N) dep++;
		dep++;
		
		start = (int)Math.pow(2, dep-1);
		sTree = new long[(int)Math.pow(2, dep)];
		for(int i = 0; i < N; i++) sTree[start+i] = Long.parseLong(br.readLine());
		for(int i = start-1; i > 0; i--) sTree[i] = sTree[i*2]+sTree[i*2+1];
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if(a == 1) change(c, start+b-1);
			else sb.append(getAcc(1, start, sTree.length-1, start+b-1, start+c-1)+"\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	private static void change(long num, int i) {
		sTree[i] = num;
		i /= 2;
		while(i > 0) {
			sTree[i] = sTree[i*2]+sTree[i*2+1];
			i /= 2;
		}
	}
	
	private static long getAcc(int num, int start, int end, int left, long right) {
		if(start > right || end < left) return 0;
		
		if(left <= start && end <= right) return sTree[num];
		
		return getAcc(num*2, start, (start+end)/2, left, right)
				+ getAcc(num*2+1, (start+end)/2+1, end, left, right);
	}
}