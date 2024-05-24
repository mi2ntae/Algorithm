import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    private static long[] segTree;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] a = new int[N];
        int[] b = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) a[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) b[i] = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++) map.put(b[i], i);

        int k = 0;
        while(Math.pow(2, k) < N) k++;
        int len = (int) Math.pow(2, k);
        segTree = new long[len*2];

        long ans = 0;
        for(int i = 0; i < N; i++) {
            int cur = a[i];
            int bi = map.get(cur);
            change(len+bi, 1);
            ans += find(1, len, segTree.length-1, len+bi+1, segTree.length-1);
        }
        System.out.println(ans);
        br.close();
    }

    private static void change(int i, int v) {
        segTree[i] += v;
        i /= 2;
        while(i > 0) {
            segTree[i] = segTree[i * 2] + segTree[i * 2 + 1];
            i /= 2;
        }
    }

    private static long find(int i, int l, int r, int start, int end) {
        if(start <= l && r <= end) return segTree[i];
        if(end < l || r < start) return 0;
        int mid = (l+r)/2;
        return find(i * 2, l, mid, start, end) + find(i * 2 + 1, mid + 1, r, start, end);
    }
}