import java.util.BitSet;

public class Level3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int limit = 10000;
		BitSet set = computePrimes(limit);
		for (int i=0;i<limit;i++) {
			if (set.get(i)) {
				String primeText = String.valueOf(i);
				for (int j=10;j<limit;j++) {
					if (i!=j && set.get(j) && primeText.contains(String.valueOf(j))) {
						System.out.println(i);
						break;
					}
				}
			}
		}
	}
	
	public static BitSet computePrimes(int limit)
	{
	    final BitSet primes = new BitSet();
	    primes.set(0, false);
	    primes.set(1, false);
	    primes.set(2, limit, true);
	    for (int i = 0; i * i < limit; i++)
	    {
	        if (primes.get(i))
	        {
	            for (int j = i * i; j < limit; j += i)
	            {
	                primes.clear(j);
	            }
	        }
	    }
	    return primes;
	}

}
