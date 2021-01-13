package Circle;

class Circle {
	
	static double pi = 3.14;
	static int objectNo = 0;
	int radius;
	Circle(int r){
		radius = r;
		objectNo++;
	}
	Circle(){
		radius = 2;
		objectNo++;
	}
	double getArea() {
		return pi*radius*radius;
	}
	static void setPI(double p) {
		pi = p;
	}
	void setRadius(int r) {
		radius = r;
	}
	static void displayNo() {
		System.out.println("��ǰԲ��������ǣ�"+ objectNo);
	}
	
	public static class StaticTest{
		public static void main( String args[]) {
			Circle cir1 = new Circle(5);
			System.out.println("cir1Բ�����ǣ�" + cir1.pi);
			System.out.println("cir1�İ뾶�ǣ�" + cir1.radius);
 			System.out.println("cir1������ǣ�" + cir1.getArea());
			cir1.displayNo();
			cir1.setRadius(10);
			Circle cir2 = new Circle();
			cir2.setPI(3.1415);
			System.out.println("cir1Բ�����ǣ�" + cir1.pi);
			System.out.println("cir1�İ뾶�ǣ�" + cir1.radius);
			System.out.println("cir2�İ뾶�ǣ�" + cir2.radius);
			System.out.println("cir2������ǣ�" + cir2.getArea());
			cir2.displayNo();			
		}
	}
}
