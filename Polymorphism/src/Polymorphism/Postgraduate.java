package Polymorphism;

class Postgraduate extends Student {
	public Postgraduate(String name) {
		super (name);
		type = "�о���";
	}
	public void calculateGrade() {
		int total = 0;
		double average = 0;
		for (int i = 0; i < CourseNo; i++) {
			total += courses[i];
		}
		average = total/CourseNo;
	
	if (average>=90&&average<100) courseGrade = "����";
		else if (average>=80&&average<90) courseGrade = "����";
		else if (average>=70&&average<80) courseGrade = "һ��";
		else if (average>=60&&average<70) courseGrade = "����";
		else courseGrade = "������";
	}
}















