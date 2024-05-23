import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for(int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                String opt = st.nextToken();
                int opd = Integer.parseInt(st.nextToken());
                if(opt.equals("I")) {
                    if(treeMap.keySet().contains(opd)) {
                        treeMap.put(opd, treeMap.get(opd)+1);
                    } else treeMap.put(opd, 0);
                } else {
                    if(treeMap.size() == 0) continue;
                    if(opd == 1) {
                        if(treeMap.lastEntry().getValue() == 0) treeMap.pollLastEntry();
                        else treeMap.put(treeMap.lastKey(), treeMap.lastEntry().getValue()-1);
                    } else {
                        if(treeMap.firstEntry().getValue() == 0) treeMap.pollFirstEntry();
                        else treeMap.put(treeMap.firstKey(), treeMap.firstEntry().getValue()-1);
                    }
                }
            }
            if(treeMap.isEmpty())sb.append("EMPTY\n");
            else sb.append(treeMap.lastKey()+" "+treeMap.firstKey()+"\n");
        }
        System.out.println(sb);
        br.close();
    }
}