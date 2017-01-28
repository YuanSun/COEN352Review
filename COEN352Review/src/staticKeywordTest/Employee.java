package staticKeywordTest;

public class Employee {
	private static int count = 0;
	private String firstName;
	private String lastName;
	
	public Employee(String firstName, String lastName) {
		// Thees two statements do not make copies of original String
		// arguments. String objectin Java are immutable -- they cannot be
		// modified after they're created. Therefore, it's safe to have many
		// references to one String obj.
		this.firstName = firstName;
		this.lastName = lastName;
		
		++count;
		
		System.out.printf("Employee constructor: %s %s; count = %d%n", firstName, lastName, count);
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public static int getCount() {
		//String firstN = firstName; // this is wrong
									 // static method cannot access instance variable
		
		return count;
		
	}
}
