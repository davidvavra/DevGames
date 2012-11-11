
public class Level1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i=1;i<10000;i++) {
			if (i % 2 == 1 && i % 7 != 0) {
				System.out.println(i+"");
			}
		}
	}

}
