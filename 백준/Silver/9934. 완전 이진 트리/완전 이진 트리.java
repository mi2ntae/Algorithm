import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int cnt;
    private static int K;
    private static int[] nodes;
    private static int i = 0;
    private static int[] seq;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        cnt = (int)Math.pow(2, K)-1;
        seq = new int[cnt];
        for (int i = 0; i < cnt; i++) seq[i] = Integer.parseInt(st.nextToken());

        nodes = new int[cnt+1];
        lvr(1, 0);

        int g = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= cnt; i++) {
            sb.append(nodes[i]+" ");
            if((int)Math.pow(2, g)-1 == i) {
                g++;
                sb.append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }

    private static void lvr(int cur, int depth) {
        if(depth == K) return;
        lvr(cur*2, depth+1);
        nodes[cur] = seq[i++];
        lvr(cur*2+1, depth+1);
    }
}