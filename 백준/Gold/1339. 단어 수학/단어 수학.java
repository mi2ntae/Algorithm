import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] w = new Integer[26];
        for(int i = 0; i < w.length; i++) w[i] = 0;
        for(int i = 0; i < N; i++){
            String a = br.readLine();
            int k = 0;
            for(int j = a.length()-1; j >= 0; j--) {
                int num = a.charAt(j)-'A';
                w[num] += (int)Math.pow(10, k++);
            }
        }

        Arrays.sort(w, Collections.reverseOrder());

        int ans = 0;
        int k = 9;
        for(int i = 0; i < w.length; i++){
            if(w[i] == 0) break;
            ans += w[i]*k--;
        }
        System.out.println(ans);
        br.close();
    }
}