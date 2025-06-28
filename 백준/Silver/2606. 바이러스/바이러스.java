import java.util.*;
import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int k = Integer.parseInt(br.readLine());
    int p = Integer.parseInt(br.readLine());
    ArrayList<Integer>[] g = new ArrayList[k];
    for(int i = 0; i < k; i++) g[i] = new ArrayList<Integer>();
    
    for(int i = 0; i < p; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken())-1;
      int b = Integer.parseInt(st.nextToken())-1;
      g[a].add(b);
      g[b].add(a);
    }
    boolean[] v = new boolean[k];
    ArrayDeque<Integer> q = new ArrayDeque<>();

    q.offer(0);
    v[0] = true;

    int ans = 0;
    while(!q.isEmpty()) {
      int cur = q.poll();
      for(Integer nxt : (ArrayList<Integer>) g[cur]) {
        if(v[nxt]) continue;
        v[nxt] = true;
        ans++;
        q.offer(nxt);
      }
    }
    System.out.println(ans);
    br.close();
  }
}
