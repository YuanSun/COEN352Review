package polymorphismTest;

public abstract class Employee implements Payable, Payment{
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	
	public Employee(String firstName, String lastName, String ssn) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = ssn;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s%nsocial security number: %s", getFirstName(),
				getLastName(), getSocialSecurityNumber());
	}
	
	//public abstract double earnings(); //no implementationi here
	
	/**
	 * We do not implement Payable method getPaymentAmount here so
	 * this class must be declared abstract to avoid a compilation error.
	 */
}
