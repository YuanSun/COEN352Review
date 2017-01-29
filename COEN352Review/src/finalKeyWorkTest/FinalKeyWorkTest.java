package finalKeyWorkTest;

public class FinalKeyWorkTest {

	public static void main(String[] args) {
		final int[] aInt = {10, 11};
		final Double[] anotherInt = {10.0, 11.0};
		
		setValue(aInt);
		setValue(anotherInt);
		
		System.out.println("aInt is " + aInt[0] + " \nanotherInt is " + anotherInt[0]);

	}
	
	private static void setValue(int[] v) {
		v[0] = 12;
	}
	
	private static void setValue(Double[] v) {
		v[0] = 12.0;
	}
}
