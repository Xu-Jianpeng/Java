package Inheritance;

public class Telephone {
	String brand ,number;
	double dialledTime;
	double rate;
	Telephone(String b,String n){
		brand = b;
		number = n;
	}
	String getBrand() {return brand;}
	String getNumber() {return number;}
	double getRate() {return rate;}
	double getDialledTime() {return dialledTime;}
	
	void setBrand(String b) {
		brand = b;
	}
	void setNumber(String n) {
		number = n;
	}
	void setRate(double r) {
		rate = r;//设置费率
	}
	void setDialledTime(double d) {
		dialledTime = d;
	}
	double callCost() {
		return dialledTime * rate;
	}
	void display() {
		System.out.println("电话品牌："+brand+"电话号码："+number);
		System.out.println("通话时间："+dialledTime+"费率："+rate);
		System.out.println("话费："+callCost());
	}
}
