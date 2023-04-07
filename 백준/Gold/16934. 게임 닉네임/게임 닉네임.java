import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	private static class Node{
		private HashMap<Character, Node> childs;
		private boolean isEnd;
		private int users;
		public Node() {childs = new HashMap<>();}
	}
	private static Node root;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		root = new Node();
		for(int i = 0; i < N; i++) {
			String a = br.readLine();
			sb.append(search(a)+"\n");
			insert(a);
		}
		System.out.println(sb);
		br.close();
	}
	
	private static String search(String a) {
		Node node = root;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < a.length(); i++) {
			Node nxt = node.childs.get(a.charAt(i));
			sb.append(a.charAt(i));
			if(nxt == null) {
				return sb.toString();
			} else node = nxt;
		}
		if(node.isEnd) {
			if(node.users == 0) return sb.toString();
			else {
				sb.append(node.users+1);
				return sb.toString();
			}
		} else return sb.toString();
	}
	
	private static void insert(String a) {
		Node node = root;
		for(int i = 0; i < a.length(); i++) {
			Node nxt = node.childs.get(a.charAt(i));
			if(nxt == null) {
				Node newNode = new Node();
				node.childs.put(a.charAt(i), newNode);
				node = newNode;
			} else node = nxt;
		}
		node.isEnd = true;
		if(node.isEnd) node.users++;
	}
}