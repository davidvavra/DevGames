import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Level6 {

	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		System.out.println(count(line));
	}

	private static int count(String input) {
		int c = 0, j;
		char[] array = input.toCharArray();
		int n = array.length;
		for (int i = 0; i < n; i++) {
			for (j = 0; j < n - i && i + j < n; j++)
				if (array[i + j] != array[j])
					break;
			c += j;
		}
		return c;
	}
}
