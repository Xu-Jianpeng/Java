package Polymorphism;


class Undergraduate extends Student {
	public Undergraduate(String name) {
		super(name);
		type = "������";
	}
	public void calculateGrade() {
		int total = 0;
		double average = 0;
		for (int i = 0; i < CourseNo; i++) {
			total += courses[i];
		}
		average = total/CourseNo;
	
	if (average>=80&&average<100) courseGrade = "����";
		else if (average>=70&&average<80) courseGrade = "����";
		else if (average>=60&&average<70) courseGrade = "һ��";
		else if (average>=50&&average<60) courseGrade = "����";
		else courseGrade = "������";
	}
}













