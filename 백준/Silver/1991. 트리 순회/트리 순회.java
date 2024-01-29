import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static class Node {
        private char me;
        private int l;
        private int r;

        public Node(char a, int left, int right) {
            me = a;
            l = left;
            r = right;
        }


    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char cur = st.nextToken().charAt(0);
            int l = st.nextToken().charAt(0);
            int r = st.nextToken().charAt(0);
            int left = 0;
            int right = 0;
            if(l != '.') left = l-'A';
            if(r != '.') right = r-'A';
            nodes[cur-'A'] = new Node(cur, left, right);
        }
        StringBuilder sb = new StringBuilder();
        first(nodes, 0, sb);
        sb.append("\n");
        center(nodes, 0, sb);
        sb.append("\n");
        last(nodes, 0, sb);
        System.out.println(sb);
        br.close();
    }

    private static void first(Node[] nodes, int cur, StringBuilder sb) {
        sb.append(nodes[cur].me);
        if(nodes[cur].l != 0) first(nodes, nodes[cur].l, sb);
        if(nodes[cur].r != 0) first(nodes, nodes[cur].r, sb);
    }

    private static void center(Node[] nodes, int cur, StringBuilder sb) {
        if(nodes[cur].l != 0) center(nodes, nodes[cur].l, sb);
        sb.append(nodes[cur].me);
        if(nodes[cur].r != 0) center(nodes, nodes[cur].r, sb);
    }

    private static void last(Node[] nodes, int cur, StringBuilder sb) {
        if(nodes[cur].l != 0) last(nodes, nodes[cur].l, sb);
        if(nodes[cur].r != 0) last(nodes, nodes[cur].r, sb);
        sb.append(nodes[cur].me);
    }

}