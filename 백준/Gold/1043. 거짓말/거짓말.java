import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[] p;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        p = new int[N+1];
        for(int i = 1; i <= N; i++) p[i] = i;
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int truthNum = Integer.parseInt(st.nextToken());
        int[] truthNums = new int[truthNum];
        for (int i = 0; i < truthNum; i++) truthNums[i] = Integer.parseInt(st.nextToken());

        ArrayList[] parties = new ArrayList[M];
        for(int i = 0; i < M; i++) parties[i] = new ArrayList<Integer>();

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int partyNum = Integer.parseInt(st.nextToken());
            for (int j = 0; j < partyNum; j++) parties[i].add(Integer.parseInt(st.nextToken()));

        }

        for(int i = 0; i < M; i++) {
            ArrayList<Integer> cur = parties[i];
            int first = cur.get(0);
            for(int j = 1; j < cur.size(); j++) uMerge(first, cur.get(j));
        }

        boolean[] knowTruth = new boolean[N+1];
        for(int i = 1; i <= N; i++) {
            boolean isTruth = false;
            int pCur = uFind(i);
            for(int j = 0; j < truthNum; j++) {
                int pTruth = uFind(truthNums[j]);
                if(pCur == pTruth) isTruth = true;
            }
            knowTruth[i] = isTruth;
        }

        int ans = 0;
        for(int i = 0; i < M; i++) {
            ArrayList<Integer> curParty = parties[i];
            boolean isOkay = true;
            for(Integer a : curParty) {
                if(knowTruth[a]) isOkay = false;
            }
            if(isOkay) ans++;
        }

        System.out.println(ans);
        br.close();
    }

    private static int uFind(int n) {
        if(p[n] == n) return n;
        return p[n] = uFind(p[n]);
    }

    private static boolean uMerge(int a, int b) {
        int pa = uFind(a);
        int pb = uFind(b);
        if(pa == pb) return true;
        p[pb] = pa;
        return false;
    }
}