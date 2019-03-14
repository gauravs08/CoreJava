package com.InstanceVsClassVariable;

public class Circle { // only public, abstract & final are permitted for a class
						// means
	// valid [public class circle]/[public abstract class]/[public final class]
	// not valid [final abstract class Circle] -The class Circle can be either
	// abstract or final, not both

	static int num_circles = 0; // class variable(Static Variable): how many
								// circles created
	public double x, y, r; // instance vars(Non-Static variable): the centre and
							// the radius

	public Circle(double x, double y, double r) {
		this.x = x;
		this.y = y;
		this.r = r;
		num_circles++;
		System.out.println("Local varible x=" + x + ", y = " + y + ",r=" + r);
	}

	public Circle(double r) {
		this(0.0, 0.0, r);
	}

	public Circle(Circle c) {
		this(c.x, c.y, c.r);
	}

	public Circle() {
		this(0.0, 0.0, 1.0);
	}

	public double area() {
		return 3.14159 * r * r;
	}

	// if using "final" - Any inheriting class will not be able to have it's own
	// default main() method.["final" prevents from overriding in sub class]
	final static public void main(String[] args) {
		Circle circle = new Circle(2, 3, 4);
		System.out.println("Class Variable(Static) No Of Circles =="
				+ num_circles);
		System.out.println(circle.area());

		Circle circle2 = new Circle(2, 3, 5);
		System.out.println("Class Variable(Static) No Of Circles =="
				+ num_circles);
		System.out.println(circle2.area());

		Circle circle3 = new Circle(2, 3, 6);
		System.out.println("Class Variable(Static) No Of Circles =="
				+ num_circles);
		System.out.println(circle3.area());

	}

}
