import java.util.Random;


public class Generator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int limit = 100;
		System.out.println(limit);
		Random random = new Random();
		for (int i=0;i<limit;i++) {
			System.out.println(random.nextInt(500)+" "+random.nextInt(500));
		}
	}

}
