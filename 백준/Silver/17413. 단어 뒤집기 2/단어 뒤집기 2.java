import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean isTag = false;
        ArrayDeque<Character> stack = new ArrayDeque<>();
        Queue<Character> q = new ArrayDeque<>();

        String a = br.readLine();
        for (int i = 0; i < a.length(); i++) {
            char cur = a.charAt(i);
            if (cur == '<') {
                while (!stack.isEmpty()) q.offer(stack.pollLast());
                isTag = true;
                q.offer(cur);
            } else if (cur == '>') {
                isTag = false;
                q.offer(cur);
            } else if (cur == ' ' && !isTag) {
                while (!stack.isEmpty()) q.offer(stack.pollLast());
                q.offer(cur);
            } else {
                if(isTag) {
                    q.offer(cur);
                } else {
                    stack.offer(cur);
                }
            }
        }
        while (!stack.isEmpty()) q.offer(stack.pollLast());
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            sb.append(q.poll());
        }
        System.out.println(sb);
        br.close();
    }
}