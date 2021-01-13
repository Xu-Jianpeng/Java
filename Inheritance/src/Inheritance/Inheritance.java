package Inheritance;

/*public class Telephone {
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
		System.out.println("ͨ��ʱ�䣺"+brand+"���ʣ�"+rate);
		System.out.println("���ѣ�"+callCost());
	}
}*/
class Mobilephone extends Telephone{
	String network;
	double receivedTime;
	Mobilephone(String b,String num,String net){
		super(b,num);
		network = net;
	}
	String getNetwork() {return network;}
	double getReceivedTime() {return receivedTime;}
	
	void setNetwork(String n) {
		network = n;
	}
	void setReceivedTime(double d) {
		receivedTime = d;//���ñ���ʱ��
	}
	double callCost() {
		return (dialledTime + 0.5 * receivedTime);
	}
	void display() {
		System.out.println("�绰Ʒ�ƣ�"+brand+"�绰���룺"+number+"���磺"+network);
		System.out.println("����ʱ�䣺"+dialledTime+"����ʱ�䣺"+receivedTime+"���ʣ�"+rate);
		System.out.println("���ѣ�"+callCost());
	}
}
public class Inheritance{
	public static void main(String[]args) {
		Telephone tel;
		Mobilephone mobile;
		tel = new Telephone("TCL","8309600");
		mobile = new Mobilephone("Nokia","13007091010","CDMA");
		tel.setRate(0.2);
		tel.setDialledTime(150);
		mobile.setRate(0.4);
		mobile.setDialledTime(80);
		mobile.setReceivedTime(120);
		tel.display();
		System.out.println();
		mobile.display();
	}
}
