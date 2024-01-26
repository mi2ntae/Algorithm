import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    private static int[] p;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<String> heap = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        for(int i = s.length()-1; i >= 0; i--) {
            sb.insert(0, s.charAt(i));
            heap.offer(sb.toString());
        }
        while(!heap.isEmpty()) {
            System.out.println(heap.poll());
        }
        br.close();
    }
}