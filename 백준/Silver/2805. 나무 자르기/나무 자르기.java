import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] trees = new int[N];
        for (int i = 0; i < N; i++) trees[i] = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = 1000000001;
        while(start+1 < end) {
            int mid = (start+end)/2;
            long sum = 0;
            for(int tree : trees) {
                if(tree > mid) sum += tree-mid;
            }
            if(sum >= M) start = mid;
            else end = mid;
        }
        System.out.println(start);
        br.close();
    }
}