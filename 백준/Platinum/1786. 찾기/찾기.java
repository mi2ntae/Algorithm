import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String T = br.readLine();
        String P = br.readLine();

        int[] table = makeFailTable(P);
        int idx = 0;
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T.length(); i++) {
            while(idx > 0 && T.charAt(i) != P.charAt(idx)) {
                idx = table[idx-1];
            }

            if(T.charAt(i) == P.charAt(idx)) {
                if(idx == P.length()-1) {
                    sb.append(i-idx+1+" ");
                    idx = table[idx];
                    cnt++;
                } else {
                    idx++;
                }
            }
        }
        sb.insert(0, cnt+"\n");
        System.out.println(sb);
    }

    private static int[] makeFailTable(String target) {
        int t = target.length();
        int[] table = new int[t];
        int idx = 0;

        for(int i = 1; i < t; i++) {
            while(idx > 0 && target.charAt(i) != target.charAt(idx)) {
                idx = table[idx-1];
            }

            if(target.charAt(i) == target.charAt(idx)) {
                idx++;
                table[i] = idx;
            }
        }
        return table;
    }
}