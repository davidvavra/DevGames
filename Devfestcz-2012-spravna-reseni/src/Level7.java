import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

public class Level7 {

	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = in.readLine();
		System.out.println(toBinary(everySecondBullshit(rot13(line))));
	}

	private static String rot13(String s) {
		String output = "";
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c >= 'a' && c <= 'm')
				c += 13;
			else if (c >= 'A' && c <= 'M')
				c += 13;
			else if (c >= 'n' && c <= 'z')
				c -= 13;
			else if (c >= 'N' && c <= 'Z')
				c -= 13;
			output += c;
		}
		return output;
	}

	private static String toBinary(String s) {
		byte[] bytes = s.getBytes();
		StringBuilder binary = new StringBuilder();
		for (byte b : bytes) {
			int val = b;
			for (int i = 0; i < 8; i++) {
				binary.append((val & 128) == 0 ? 0 : 1);
				val <<= 1;
			}
		}
		return binary.toString();
	}

	private static String everySecondBullshit(String s) {
		String output = "";
		Random r = new Random();
		for (int i = 0; i < s.length(); i++) {
			output += s.charAt(i);
			output += (char) (r.nextInt(26) + 'a');
		}
		return output;
	}
}
