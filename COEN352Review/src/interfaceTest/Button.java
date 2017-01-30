package interfaceTest;

public class Button implements Clickable, Accessible{
	public static void main(String[] args) {
		Button button = new Button();
		button.calling();
		
	}
	
	public void calling() {
		Clickable.super.calling();
		Accessible.super.calling();
	}
}