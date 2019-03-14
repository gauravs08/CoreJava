package mockEx;

public class Outer {
	private static int value =4;
	private  class Inner  {
		private int a;
		Inner(){a=1;}
		public void display(){
			System.out.println(value);
			System.out.println(getValue());
			System.out.println(A.getValue());
		}
	}
	public static void main(String[] args) {
		//new Outer.Inner();
		//Outer.createInner();
		//Outer.Inner in = new Outer.Inner();
		//Outer.Inner.new();
		Outer out = new Outer();
		Outer.Inner in = out.new Inner();
		//Outer.Inner in = new Outer.Inner();
		//Inner in = new Outer.Inner();
		in.display();
	}
	/*public static Inner createInner(){
		return Inner();
	}*/
	public static int getValue(){
		return value;
	}

}
