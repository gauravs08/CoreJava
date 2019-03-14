package mockEx;

public class SuperClass {
	public void printIt() {
		System.out.println("SuperClass.");
	}

	public void printIt(boolean print) {
		if (print) {
			System.out.println("Super-PartII");
		} else {
			printIt();
		}
	}
}
class SubClass extends SuperClass {
	public void printIt() {
		System.out.println("SubClass.");
	}
}
class TestSub{
	public static void main(String args[]){
		SuperClass sup =  new SubClass();
		sup.printIt();
		sup.printIt(false);
		System.out.println(sup.getClass().getName());
	}
}