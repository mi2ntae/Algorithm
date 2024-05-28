import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int[][] sudo, zeroes;
    private static boolean[][] v;
    private static int[][] ans;
    private static boolean find;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sudo = new int[9][9];
        v = new boolean[27][10];

        int zero = 0;
        for(int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                sudo[i][j] = Integer.parseInt(st.nextToken());
                if(sudo[i][j] == 0) {
                    zero++;
                    continue;
                }
                v[i][sudo[i][j]] = true;
                v[j+9][sudo[i][j]] = true;
                v[18+((i/3)*3)+(j/3)][sudo[i][j]] = true;
            }
        }

        zeroes = new int[zero][2];
        zero = 0;
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(sudo[i][j] != 0) continue;
                zeroes[zero][0] = i;
                zeroes[zero++][1] = j;
            }
        }

        ans = new int[9][9];
        sudoku(0);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) sb.append(ans[i][j]+" ");
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static void sudoku(int cnt) {
        if(find) return;
        if(cnt == zeroes.length) {
            find = true;
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) ans[i][j] = sudo[i][j];
            }
            return;
        }

        int i = zeroes[cnt][0];
        int j = zeroes[cnt][1];
        for(int n = 1; n <= 9; n++) {
            if(!v[i][n] && !v[j+9][n] && !v[18+((i/3)*3)+(j/3)][n]) {
                v[i][n] = true;
                v[j+9][n] = true;
                v[18+((i/3)*3)+(j/3)][n] = true;
                sudo[i][j] = n;
                sudoku(cnt+1);
                sudo[i][j] = 0;
                v[18+((i/3)*3)+(j/3)][n] = false;
                v[j+9][n] = false;
                v[i][n] = false;
            }
        }

    }
}