import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.io.BufferedReader;

public class Main {
	private static class Ent implements Comparable<Ent>{
		private String key;
		private int value;
		
		public Ent(String key, int value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public int compareTo(Ent o) {
			return this.key.compareTo(o.key);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = "";
		Map<String, Integer> map = new HashMap<>();
		int cnt = 0;
		while((input = br.readLine()) != null) {
			cnt++;
			if(map.containsKey(input)) map.put(input, map.get(input)+1);
			else map.put(input, 1);
		}
		ArrayList<Ent> list = new ArrayList<>();
		for(Entry<String, Integer> e : map.entrySet()) {
			Ent ent = new Ent(e.getKey(), e.getValue());
			list.add(ent);
		}
		
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for(Ent e : list) sb.append(e.key+" "+String.format("%.4f", 100.0*e.value/cnt)+"\n");
		System.out.println(sb);
		br.close();
	}
}