package mockEx;

class classDoc {
	public static void main (String[] args) throws java.lang.Exception
  {
static  printStuff(classDoc cd) {
    System.out.print(cd.modifiers());
    System.out.print(cd.isClass() ? " class " : " interface ");
    System.out.println(cd.qualifiedName());
    classDoc interfaces[] = cd.interfaces();
    for (int i=0, n=interfaces.length; i<n; i++) {
        System.out.println("  implements " 
            + interfaces[i].qualifiedName());
    }
    classDoc parent = cd.superclass();
    if (parent != null) {
        System.out.println("  extends " + 
            parent.qualifiedName());
    }
}
 }
}