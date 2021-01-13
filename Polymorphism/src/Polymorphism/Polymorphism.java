package Polymorphism;

public class Polymorphism {
	
	public static void main(String[] args) {
		Student[] students = new Student[5];
		students[0] = new Undergraduate("陈建平");
		students[1] = new Undergraduate("鲁向东");
		students[2] = new Postgraduate("陈建平");
		students[3] = new Undergraduate("周丽娜");
		students[4] = new Postgraduate("梁欣欣");
		for (int i = 0; i < 5; i++) {
			students[i].setCourseScore(0, 87);
			students[i].setCourseScore(1, 90);
			students[i].setCourseScore(2, 78);
		}
		for (int i = 0; i < 5; i++) {
			students[i].calculateGrade();
		}
		System.out.println("姓名"+"\t类型"+"\t成绩");
		System.out.println("———————————————————");
		for (int i = 0; i < 5; i++) {
			System.out.println(students[i].getName()+"\t"+
							   students[i].getType()+"\t"+
							   students[i].getCourseGrade());
		}
	}
}









