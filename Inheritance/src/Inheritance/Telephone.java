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
		rate = r;//���÷���
	}
	void setDialledTime(double d) {
		dialledTime = d;
	}
	double callCost() {
		return dialledTime * rate;
	}
	void display() {
		System.out.println("�绰Ʒ�ƣ�"+brand+"�绰���룺"+number);
		System.out.println("ͨ��ʱ�䣺"+dialledTime+"���ʣ�"+rate);
		System.out.println("���ѣ�"+callCost());
	}
}
