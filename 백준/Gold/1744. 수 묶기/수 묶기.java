import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> pnums = new ArrayList<>();
        ArrayList<Integer> mnums = new ArrayList<>();
        int oneCnt = 0;
        int zeroCnt = 0;
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) zeroCnt++;
            else if(num == 1) oneCnt++;
            else if(num > 1) pnums.add(num);
            else mnums.add(num);
        }

        Collections.sort(pnums, Collections.reverseOrder());
        Collections.sort(mnums);

        int ans = 0;
        int i = 0;
        if(pnums.size()%2 == 0) {
            while(i < pnums.size()) {
                ans += pnums.get(i) * pnums.get(i+1);
                i += 2;
            }
        } else {
            while(i < pnums.size()-1) {
                ans += pnums.get(i) * pnums.get(i+1);
                i += 2;
            }
            ans += pnums.get(i);
        }

        i = 0;
        if(mnums.size()%2 == 0) {
            while(i < mnums.size()) {
                ans += mnums.get(i) * mnums.get(i+1);
                i += 2;
            }
        } else {
            while(i < mnums.size()-1) {
                ans += mnums.get(i) * mnums.get(i+1);
                i += 2;
            }
            if(zeroCnt == 0) ans += mnums.get(i);
        }
        ans += oneCnt;
        System.out.println(ans);
        br.close();
    }
}