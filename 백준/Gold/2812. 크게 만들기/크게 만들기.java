import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        String a = br.readLine();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i = 0; i < N; i++) {
            int cur = a.charAt(i)-'0';
            while (!stack.isEmpty()) {
                if(stack.peekLast() < cur && K > 0) {
                    stack.pollLast();
                    K--;
                } else break;
            }
            stack.offer(cur);
        }

        while(K > 0) {
            stack.pollLast();
            K--;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.poll());
        }
        System.out.println(sb);
        br.close();
    }


}