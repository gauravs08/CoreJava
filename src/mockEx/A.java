package mockEx;

import java.util.Random;

public class A{
	private static int value =4;
	public  class Y{
		public void display(){
			System.out.println(value);
			System.out.println(getValue());
			System.out.println(A.getValue());
		}
	}
	public static void main(String... args){
		int i=0,count=0;
		System.out.println("Starting...");
		do{
			count+=i;
			i++;
			if(count>5) break;
		}while(i<=4);
		
		System.out.println("count = "+count+" i="+i);
		A outer = new A();
		A.Y y = outer.new Y();
		y.display();
		
//--------------
		
		
	}
	public static int getValue(){
		return value;
	}
	
}

class TestAssert {
	String f(int i) {
		switch (i) {
		case 0:
			return "A";
		case 1:
			return "B";
		case 2:
			return "C";
		default:
			assert true:i;
		//System.out.println(i);
		}
		return null;
	}

	public static void main(String[] args) {
		TestAssert t = new TestAssert();
		Random r = new Random();
		for (int i = 0; i < 20; i++) {
			//System.out.println(t.f(i));
			int rx = r.nextInt(100)+1;
			//int rx =(int)(Math.random()*100);
			System.out.println(rx);
		}
		t.f(5);
		
		
	}
}