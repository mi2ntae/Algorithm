import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[] houses = new int[N];
        for (int i = 0; i < N; i++) houses[i] = Integer.parseInt(br.readLine());
        Arrays.sort(houses);

        int start = 0;
        int end = 1000000001;
        while(end-start > 1) {
            int mid = (start+end)/2;
            int dist = 0;
            int bef = houses[0];
            int cnt = 1;
            for(int i = 1; i < N; i++) {
                dist += houses[i]-bef;
                if(dist >= mid) {
                    cnt++;
                    dist = 0;
                }
                bef = houses[i];
            }
            if(cnt >= C) start = mid;
            else end = mid;
        }
        System.out.println(start);
        br.close();
    }
}