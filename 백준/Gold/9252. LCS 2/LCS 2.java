import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int[][] dp = new int[a.length()+1][b.length()+1];
        for(int i = 1; i <= a.length(); i++) {
            for(int j = 1; j <= b.length(); j++) {
                char ac = a.charAt(i - 1);
                char bc = b.charAt(j - 1);
                if(ac == bc) dp[i][j] = dp[i-1][j-1]+1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        int i = a.length();
        int j = b.length();
        StringBuilder sb = new StringBuilder();
        sb.append(dp[i][j]+"\n");
        ArrayDeque<Character> q = new ArrayDeque<>();
        while (i > 0 && j > 0) {
            if(dp[i][j] == dp[i-1][j]) i--;
            else {
                if(dp[i][j] == dp[i][j-1]) j--;
                else {
                    q.offer(a.charAt(i-1));
                    i--;
                    j--;
                }
            }
        }
        while(!q.isEmpty()) sb.append(q.pollLast());
        System.out.println(sb);
        br.close();
    }
}