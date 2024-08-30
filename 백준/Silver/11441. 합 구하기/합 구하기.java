import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] acc = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            if(i == 0) acc[i] = Integer.parseInt(st.nextToken());
            else acc[i] = acc[i-1]+Integer.parseInt(st.nextToken());;
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            if(a == 0) sb.append(acc[b]+"\n");
            else sb.append(acc[b] - acc[a - 1]+"\n");
        }
        System.out.println(sb);
        br.close();
    }
}