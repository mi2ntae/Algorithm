import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        HashMap<String, ArrayList<String>> g = new HashMap<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String a = st.nextToken();
            String b = st.nextToken();
            if (!g.containsKey(a)) g.put(a, new ArrayList<String>());
            if (!g.containsKey(b)) g.put(b, new ArrayList<String>());
            ArrayList<String> p = g.get(a);
            p.add(b);
            g.put(a, p);
            if(!treeMap.containsKey(a)) treeMap.put(a, 0);
            if(!treeMap.containsKey(b)) treeMap.put(b, 0);
            treeMap.put(b, treeMap.get(b)+1);
        }

//        for (Map.Entry<String, Integer> cur : treeMap.entrySet()) {
//            System.out.println(cur.getKey()+" "+cur.getValue());
//        }
//
//        for (Map.Entry<String, ArrayList<String>> cur : g.entrySet()) {
//            System.out.println(cur.getKey()+" "+cur.getValue());
//        }

        int res = 0;
        StringBuilder sb = new StringBuilder();
        ArrayDeque<String> q = new ArrayDeque<>();
        for (Map.Entry<String, Integer> cur : treeMap.entrySet()) {
            if(cur.getValue() == 0) {
                q.offer(cur.getKey());
                res++;
                sb.append(cur.getKey() + "\n");
            }
        }

        PriorityQueue<String> heap = new PriorityQueue<>();
        while(true) {
            while (!q.isEmpty()) {
                String cur = q.poll();
                for (String nxt : g.get(cur)) {
                    int indegree = treeMap.get(nxt);
                    if (--indegree == 0) heap.offer(nxt);
                    treeMap.put(nxt, indegree);
                }
            }
            if(heap.size() == 0) break;
            while(!heap.isEmpty()) {
                String item = heap.poll();
                q.offer(item);
                res++;
                sb.append(item + "\n");
            }
        }


        if(res != g.size()) System.out.println(-1);
        else System.out.println(sb);
        br.close();
    }
}