import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	private static int N;
	private static String a;
	private static int ans = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		a = br.readLine();
		calc(1, new int[N]);
		System.out.println(ans);
		br.close();
	}

	private static void calc(int cur, int[] path) {
		if(cur >= N) {
			ArrayDeque<String> stack = new ArrayDeque<>();
			stack.offer(a.substring(0, 1));
			for(int i = 1; i < N; i++) {
				if(path[i] == 1) {
					int op1 = Integer.parseInt(stack.pollLast());
					int op2 = a.charAt(i+1)-'0';
					if(a.charAt(i) == '+') stack.offer(Integer.toString(op1+op2));
					else if(a.charAt(i) == '-') stack.offer(Integer.toString(op1-op2)); 
					else stack.offer(Integer.toString(op1*op2));
					i += 1;
				} else stack.offer(a.substring(i, i+1));
			}
			calc2(stack);
			return;
		}
		path[cur] = 1;
		calc(cur+4, path);
		path[cur] = 0;
		calc(cur+2, path);
	}

	private static void calc2(ArrayDeque<String> stack) {
		int res = 0;
		res = Integer.parseInt(stack.poll());
		while(!stack.isEmpty()) {
			char opt = stack.poll().charAt(0);
			if(opt == '+') res += Integer.parseInt(stack.poll());
			else if(opt == '-') res -= Integer.parseInt(stack.poll());
			else res *= Integer.parseInt(stack.poll());
		}
		ans = ans < res ? res : ans;
	}
}