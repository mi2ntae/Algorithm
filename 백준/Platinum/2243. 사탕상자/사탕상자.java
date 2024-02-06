import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int start;
    private static int[] segTree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int k = 0;
        while (Math.pow(2, k) < 1000000) k++;
        start = (int) Math.pow(2, k);
        segTree = new int[(int) Math.pow(2, k + 1)];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int cmd = Integer.parseInt(st.nextToken());
            if (cmd == 1) {
                int sequence = Integer.parseInt(st.nextToken());
                sb.append(find(start, segTree.length-1, 1, sequence)+"\n");
            } else {
                int taste = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                insert(start+taste-1, w);
            }
        }
        System.out.println(sb);
        br.close();
    }

    private static void insert(int taste, int w) {
        segTree[taste] += w;
        taste /= 2;
        while (taste > 0) {
            segTree[taste] = segTree[taste * 2] + segTree[taste * 2 + 1];
            taste /= 2;
        }
    }

    private static int find(int l, int r, int n, int sequence) {
        if(l == r) {
            insert(n, -1);
            return n-start+1;
        }
        if(segTree[n*2] >= sequence) return find(l, (l+r)/2, n*2, sequence);
        else return find((l+r)/2+1, r, n*2+1, sequence-segTree[n*2]);
    }
}