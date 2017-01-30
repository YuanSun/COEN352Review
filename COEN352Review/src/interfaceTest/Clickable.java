package interfaceTest;

public interface Clickable {
	default void click() {
		System.out.println("Click");
	}
	
	default void calling() {
		System.out.println("calling from Clickable");
	}
}
