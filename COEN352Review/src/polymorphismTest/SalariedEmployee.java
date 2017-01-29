package polymorphismTest;

public class SalariedEmployee extends Employee {
	private double weeklySalary;
	
	public SalariedEmployee(String firstName, String lastName, String ssn, 
			double weeklySalary) {
		super(firstName, lastName, ssn);
		
		if(weeklySalary < 0.0)
			throw new IllegalArgumentException(
					"weekly salary must be >= 0");
		
		this.weeklySalary = weeklySalary;
	}
	
	public void setWeeklySalary(double weeklySalary) {
		if(weeklySalary < 0.0)
			throw new IllegalArgumentException(
					"weekly salary must be >= 0");
		
		this.weeklySalary = weeklySalary;
	}
	
	public double getWeeklySalary() {
		return weeklySalary;
	}

	@Override 
	public double getPaymentAmount() {
		return getWeeklySalary();
	}
	
	@Override
	public String toString() {
		return String.format("salaried employee: %s%n%s: $%,.2f", 
				super.toString(), 
				"weekly salary", 
				getWeeklySalary());
	}
}
