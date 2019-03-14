package mockEx;

import java.util.ArrayList;
import java.util.List;

class TestA {
	public boolean start() {
		System.out.println("TestA");
		return false;
	}
}

class TestB extends TestA {
	public boolean start() {
		System.out.println("TestB");
		return(7<5);
	}

	public static void main(String[] args) {
		boolean b =((TestA) new TestB()).start();
		System.out.println();
		String str1="my name is bob";
		String str2 ="my name si bob";
		
		if(str1 ==str2){
			System.out.println("str1==str2");
		}
	/*	if(str1 <>str2){
			System.out.println("str1<>str2");
		}
		if((str1 -str2)==0){
			System.out.println("str1-str2");
		}
		if(str1.compareTo(str2)){
			System.out.println("str1==str2");
		}
	*/	if(str1.equals(str2)){
			System.out.println("str1.equals(str2)");
		}
List<String[]> list = new ArrayList<String[]>();
	}
}