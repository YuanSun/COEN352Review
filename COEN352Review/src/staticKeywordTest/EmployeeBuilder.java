package staticKeywordTest;

public class EmployeeBuilder {
	private final String firstName;
	private final String lastName;
	private static int count = 0;
	
	public static class Builder {
		private String firstName;
		private String lastName;
		
		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		
		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		public EmployeeBuilder build() {
			return new EmployeeBuilder(this);
		}
	}
	
	private EmployeeBuilder(Builder builder) {
		firstName = builder.firstName;
		lastName = builder.lastName;
		++count;
	}
	
	public static int getCount() {
		return count;
	}
	
	public String toString() {
		return String.format("Employee: %s %s; Total emplooyees: %d%n", firstName, lastName, count);
	}
}
