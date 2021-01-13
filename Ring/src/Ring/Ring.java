package Ring;

public class Ring {
	private double innerRadius;
	private double outerRadius;
	public String color;
	public Ring(double iRadius,double oRadius,String c) {
		innerRadius = iRadius;
		outerRadius = oRadius;
		color = c;
	}
	
	public double getInnerRadius() {
		return innerRadius;
	}
	
	public double getOuterRadius() {
		return outerRadius;
	}
	
	public void setInnerRadius(double iRadius) {
		innerRadius = iRadius;
	}
	
	public void setOuterRadius(double oRadius) {
		outerRadius = oRadius;
	}
	
	public void setColor(String c) {
		color = c;
	}
	
	public double getArea() {
		return (outerRadius * outerRadius - innerRadius * innerRadius) * 3.1415;
	}
	
	public static void main(String[]args) {
		Ring ring = new Ring(5,8,"red");
		System.out.println("圆环的内半径："+ ring.getInnerRadius());
		System.out.println("圆环的外半径："+ ring.getOuterRadius());
		System.out.println("圆环的颜色："+ ring.color);
		System.out.println("圆环的面积："+ ring.getArea()+"\n");
		ring.setInnerRadius(4);
		ring.setOuterRadius(6);
		ring.setColor("blue");
		System.out.println("圆环的内半径："+ ring.getInnerRadius());
		System.out.println("圆环的外半径："+ ring.getOuterRadius());
		System.out.println("圆环的颜色："+ ring.color);
		System.out.println("圆环的面积："+ ring.getArea());		
	}
}
