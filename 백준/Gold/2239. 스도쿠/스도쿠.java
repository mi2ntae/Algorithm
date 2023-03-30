import java.io.*;
import java.util.*;

public class Main {
    static int[][] map = new int[9][9];
    static List<int[]> target = new ArrayList<int[]>();
    private static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            String a = br.readLine();
            for (int j = 0; j < 9; j++)  {
            	map[i][j] = a.charAt(j) - '0';
            	if(map[i][j] == 0) target.add(new int[] {i, j});
            }
        }
        sudo(0);
    }
    
    private static void sudo(int index) {
    	if(index == target.size()) {
    		for(int i = 0; i < 9; i++) sb.append(Arrays.toString(map[i]).replaceAll("[^0-9]", "")+"\n");
    		System.out.println(sb);
    		System.exit(0);
    	}
    	
    	int cury = target.get(index)[0];
    	int curx = target.get(index)[1];
    	boolean[] nums = new boolean[10];
    	for(int i = 0; i < 9; i++) {
    		nums[map[cury][i]] = true;
    		nums[map[i][curx]] = true;
    	}
    	
    	for(int i = 0; i < 3; i++) {
    		for(int j = 0; j < 3; j++) nums[map[cury/3*3+i][curx/3*3+j]] = true;
    	}
    	
    	for(int i = 1; i <= 9; i++) {
    		if(nums[i]) continue;
    		map[cury][curx] = i;
    		sudo(index+1);
    		map[cury][curx] = 0;
    	}
    }
}