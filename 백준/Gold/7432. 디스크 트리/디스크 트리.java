import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Main {
	private static class Node {
		private TreeMap<String, Node> childs;
		private boolean isEnd;
		
		public Node() {
			this.childs = new TreeMap<>();
		}
	}
	
	private static Node root;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		root = new Node();
		for(int i = 0; i < N; i++) {
			String a = br.readLine();
			makeTrie(a);
		}
		printTrie(root, sb, 0);
		System.out.println(sb);
		br.close();
	}
	
	private static void makeTrie(String a) {
		String[] keys = a.split("\\\\");
		Node cur = root;
		for(int i = 0; i < keys.length; i++) {
			Node nxt = cur.childs.get(keys[i]);
			if(nxt == null) {
				Node newNode = new Node();
				cur.childs.put(keys[i], newNode);
				cur = newNode;
			} else cur = nxt;
		}
		cur.isEnd = true;
	}
	
	private static void printTrie(Node cur, StringBuilder sb, int cnt) {
		for(String s : cur.childs.keySet()) {
			for(int i = 0; i < cnt; i++) sb.append(" ");
			sb.append(s+"\n");
			printTrie(cur.childs.get(s), sb, cnt+1);
		}
	}
}