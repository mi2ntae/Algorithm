import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int[] parents;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		double[][] stars = new double[N][2];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			double y = Double.parseDouble(st.nextToken());
			double x = Double.parseDouble(st.nextToken());
			stars[i][0] = y;
			stars[i][1] = x;
		}
		PriorityQueue<double[]> heap = new PriorityQueue<>((o1, o2) -> Double.compare(o1[2], o2[2]));
		for(int i = 0; i < N; i++) {
			for(int j = i+1; j < N; j++) heap.offer(new double[] {i, j, cal(i, j, stars)});
		}
		parents = new int[N];
		for(int i = 0; i < N; i++) parents[i] = i;
		
		double ans = 0.0;
		while(!heap.isEmpty()) {
			double[] cur = heap.poll();
			if(union((int)cur[0], (int)cur[1])) ans += cur[2];
		}
		System.out.println(ans);
		br.close();
	}
	
	private static double cal(int i, int j, double[][] stars) {
		return Math.round(Math.sqrt(Math.pow(stars[i][0]-stars[j][0], 2)+Math.pow(stars[i][1]-stars[j][1], 2))*100)/100.0;
	}
	
	private static int find(int a) {
		if(parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if(pa == pb) return false;
		parents[pb] = pa;
		return true;
	}
}