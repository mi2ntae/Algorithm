import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[][] segTree;
    private static int size;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int k = 0;
        while(Math.pow(2, k) < N) k++;
        size = (int)Math.pow(2, k);

        segTree = new int[size*2][2];
        for (int i = 0; i < segTree.length; i++) segTree[i] = new int[]{1000000001, 0};
        for (int i = 0; i < N; i++) segTree[size + i] = new int[]{Integer.parseInt(st.nextToken()), i};
        for(int i = size-1; i > 0; i--) segTree[i] = calMin(segTree[i*2], segTree[i*2+1]);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int cmd = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(cmd == 1) {
                change(size+a-1, b);
            } else {
                int[] res = find(1, size, segTree.length-1, size+a-1, size+b-1);
                sb.append(res[1]+1 + "\n");
            }
        }
        System.out.println(sb);
        br.close();
    }

    private static void change(int i, int n) {
        segTree[i] = new int[]{n, i-size};
        i /= 2;
        while(i >= 1) {
            segTree[i] = calMin(segTree[i*2], segTree[i*2+1]);
            i /= 2;
        }
    }

    private static int[] find(int n, int l, int r, int start, int end) {
        if(start <= l && r <= end) return segTree[n];
        if(end < l || r < start) return new int[]{1000000001, 0};
        int mid = (l+r)/2;
        return calMin(find(n*2, l, mid, start, end), find(n*2+1, mid+1, r, start, end));
    }

    private static int[] calMin(int[] pre, int[] nxt) {
        if(pre[0] == nxt[0]) {
            if(pre[1] < nxt[1]) return pre;
            else return nxt;
        } else {
            if(pre[0] < nxt[0]) return pre;
            else return nxt;
        }
    }
}