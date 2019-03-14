package mockEx;

public class Sample {
String name;
private Sample(String name){
	this.name = name;
	
}
@Override
public int hashCode(){
	return name.hashCode();
}
@Deprecated
public static String getCompanyName(){
	return "Brainbench";

}
public String getName(){
	return name;
}
}

