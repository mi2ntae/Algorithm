import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	private static class Node{
		private HashMap<Character, Node> childs;
		private boolean isEnd;
		
		public Node() {
			this.childs = new HashMap<>();
		}
	}
	
	private static Node root;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			root = new Node();
			boolean isConsistent = true;
			for(int i = 0; i < N; i++) {
				if(!insert(br.readLine())) isConsistent = false;
			}
			if(isConsistent) sb.append("YES\n");
			else sb.append("NO\n");
		}
		System.out.println(sb);
		br.close();
	}
	
	private static boolean insert(String a) {
		Node node = root;
		Node nxt = null;
		for(int i = 0; i < a.length(); i++) {
			nxt = node.childs.get(a.charAt(i));
			if(nxt == null) {
				Node newNode = new Node();
				node.childs.put(a.charAt(i), newNode);
				node = newNode;
			} else {
				node = nxt;
				if(nxt.isEnd) return false;
			}
		}
		node.isEnd = true;
		if(node.childs.size() != 0) return false;
		return true;
	}
}