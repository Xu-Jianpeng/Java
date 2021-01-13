package Polymorphism;

public class Polymorphism {
	
	public static void main(String[] args) {
		Student[] students = new Student[5];
		students[0] = new Undergraduate("�½�ƽ");
		students[1] = new Undergraduate("³��");
		students[2] = new Postgraduate("�½�ƽ");
		students[3] = new Undergraduate("������");
		students[4] = new Postgraduate("������");
		for (int i = 0; i < 5; i++) {
			students[i].setCourseScore(0, 87);
			students[i].setCourseScore(1, 90);
			students[i].setCourseScore(2, 78);
		}
		for (int i = 0; i < 5; i++) {
			students[i].calculateGrade();
		}
		System.out.println("����"+"\t����"+"\t�ɼ�");
		System.out.println("��������������������������������������");
		for (int i = 0; i < 5; i++) {
			System.out.println(students[i].getName()+"\t"+
							   students[i].getType()+"\t"+
							   students[i].getCourseGrade());
		}
	}
}









