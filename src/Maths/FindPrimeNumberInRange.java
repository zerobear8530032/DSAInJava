package Maths;

public class FindPrimeNumberInRange {

	public static void main(String[] args) {
		int n =40;
		boolean [] primes = new boolean [n+1];
		scieve(n,primes);
	}
	public static void scieve(int n, boolean [] primes) {
		for(int i =2;i*i<=n;i++) {
			for(int j =i*2;j<n;j+=i) {
				primes[j]=true;
			}
		}
		for(int i =2;i<n;i++) {
			if (!primes[i]) {
				System.out.print(i+"\t");				
			}
		}
	}
}
