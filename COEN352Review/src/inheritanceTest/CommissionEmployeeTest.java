package inheritanceTest;

public class CommissionEmployeeTest {

	public static void main(String[] args) {
		CommissionEmployee employee = new CommissionEmployee("Sue", "Jones", "2222-22-2222", 10000, 0.06);
		
		System.out.printf("%s", employee);

		BasePlusCommissionEmployee employee2 = new BasePlusCommissionEmployee("Sue", 
				"Jones", "2222-22-2222", 10000, 0.06, 3000);
		
		System.out.printf("%n%n%s", employee2);
		
		CommissionEmployee employee3 = employee2; // assign a subclass to a superclass
		
		// When a superclass variable contains a reference to a subclass object, 
		// and that refernece is used to call a method, the subclass version of
		// the method is called
		System.out.printf("%n%n%s", employee3); // containing base salary info.
	}

}
