package InnerClass;

import InnerClass.Outer.Inner;

public class Outer {
public static class Inner  {
	private int a =1;
	Inner(){System.out.println(a);}
	
}
public static Inner createInner(){
	return new Inner();
}

public  static void  main(String args[]){
	//which one of the following code  obtains a reference to new Inner object  from another class.
	//Outer.new Inner();
	//Outer.Inner.new();
	Outer.createInner();
	//new Outer.Inner();
	//new Outer.new Inner();
}
}
class Other{
	public  static void  main(String args[]){
		
		Inner outer = new Outer.Inner();
		
		Outer out = new Outer();
		out.createInner();
		//System.out.println(outer);
	}
}
