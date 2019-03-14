package InnerClass;

 public class InnerClassExample {
	// We can not declare top level class as static, but only inner class can be declared static.
	// only public, abstract & final are permitted
	//Invalid [static public class InnerClassExample]

	 int x = 0, y = 0;
	 public static final int asd;
	public static int statVar ;
	static class InnerClass {
		public static void InnerMethod() {
			System.out.println("Static Inner Class!");
		}
	}

	public static void sayHello()
	{
		System.out.println("Hello & Welcome");
		
	}
	/*
	 * Static blocks get executed when the class gets loaded into the memory
	 *  and even before the creation of an object.
	 *  Hence it will be executed before the main() method.
	 *   And it will be executed only once.
	 * */
	static{   // we cant use this in Static method to refer instance variable 
		//x = 10;  //invalid [this.x = 10;]
		//y = 10;  // invalid [ y = 10;] // Cannot make a static reference to the non-static field y
		int zxc ;
		asd= 10; //static final can only be initialised once 
		//asd =20; //see this will return an error as stated above and we hhave to initialised in static block
		statVar =20;
		System.out.println("In Static");
		sayHello();
	}
	
	public String sayBye()
	{
		final int myvar =10;  //only final are permitted inside a method , invalid[static int myvar = 10;]
		return "bye";
	}
	public static void main(String args[]) {
		InnerClassExample.InnerClass.InnerMethod();
		
		sayHello();    // since this method is static so we can use it without creating an obj of this class
						//as it is available before instantiation of class 
		
		InnerClassExample obj = new InnerClassExample();
		System.out.println(obj.sayBye()); //sayBye is normal method which can be accessed only when class is instantiated
		
		}
}