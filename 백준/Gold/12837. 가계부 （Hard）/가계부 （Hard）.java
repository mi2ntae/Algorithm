import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static long[] segTree;
    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int k = 0;
        while(Math.pow(2, k) < N) k++;
        int len = (int) Math.pow(2, k);
        segTree = new long[len*2];
        int Q = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int opt = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            if(opt == 1) change(len+p-1, q);
            else sb.append(find(1, len, segTree.length-1, len+p-1, len+q-1)+"\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static void change(int i, int v) {
        segTree[i] += v;
        i /= 2;
        while(i > 0 ) {
            segTree[i] = segTree[i * 2] + segTree[i * 2 + 1];
            i /= 2;
        }
    }

    private static long find(int i, int l, int r, int start, int end) {
        if(start <= l && r <= end) return segTree[i];
        if(r < start || end < l) return 0;
        int mid = (l+r)/2;
        return find(i*2, l, mid, start, end) + find(i*2+1, mid+1, r, start, end);
    }
}