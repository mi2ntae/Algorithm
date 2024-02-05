import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static long[] segTree;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = 0;
        while(Math.pow(2, k) < N) k++;
        segTree = new long[(int)Math.pow(2, k+1)];
        int sk = (int) Math.pow(2, k);
        StringBuilder sb = new StringBuilder();
        for(; M > 0; M--) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(command == 0) {
                if(a > b) {
                    int tmp = a;
                    a = b;
                    b = tmp;
                }
                sb.append(find(sk, segTree.length-1, a+sk-1, b+sk-1, 1)+"\n");
            }
            else insert(b, a+sk-1);
        }
        System.out.println(sb);
    }

    private static void insert(int n, int i) {
        segTree[i] = n;
        i /= 2;
        while(i > 0) {
            segTree[i] = segTree[i*2] + segTree[i*2+1];
            i /= 2;
        }
    }
    private static long find(int l, int r, int start, int end, int n) {
        if(start <= l && r <= end) return segTree[n];
        if(r < start || l > end) return 0;
        int mid = (l+r)/2;
        return find(l, mid, start, end, n*2) + find(mid+1, r, start, end, n*2+1);
    }
}