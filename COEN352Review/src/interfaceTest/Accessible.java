package interfaceTest;

public interface Accessible {
	default void access() {
		System.out.println("Access");
	}
	
	default void calling() {
		System.out.println("Calling from Accessible");
	}
}
