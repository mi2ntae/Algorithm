import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if(N == 1 || N == 3 || N%4 == 1 || N%4 == 3) System.out.println("SK");
		else System.out.println("CY");
		br.close();
	}
}