import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int[] ans = new int[N];
        for(int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                int[] p = stack.peekLast();
                if(p[0] >= cur) break;
                ans[p[1]] = cur;
                stack.pollLast();
            }
            stack.offer(new int[]{cur, i});
        }
        while (!stack.isEmpty()) {
            int[] p = stack.pollLast();
            ans[p[1]] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for(Integer a : ans) sb.append(a + " ");
        System.out.println(sb);
        br.close();
    }
}