import java.util.Scanner;

public class Level5 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pocet = sc.nextInt();
		int[] x = new int[pocet + 1];
		int[] y = new int[pocet + 1];
		for (int i = 0; i < pocet; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		x[pocet] = x[0];
		y[pocet] = y[0];
		System.out.println(spocitej(x, y));
	}

	static int spocitej(int[] x, int[] y) {
		double delka = 0;
		for (int i = 0; i < x.length - 1; i++) {
			double dd = Math.sqrt((x[i] - x[i + 1]) * (x[i] - x[i + 1]) + (y[i] - y[i + 1]) * (y[i] - y[i + 1]));
			delka += dd;
		}
		return (int) Math.ceil(delka * 5);
	}
}
