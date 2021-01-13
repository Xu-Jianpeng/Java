package Polymorphism;

class Postgraduate extends Student {
	public Postgraduate(String name) {
		super (name);
		type = "研究生";
	}
	public void calculateGrade() {
		int total = 0;
		double average = 0;
		for (int i = 0; i < CourseNo; i++) {
			total += courses[i];
		}
		average = total/CourseNo;
	
	if (average>=90&&average<100) courseGrade = "优秀";
		else if (average>=80&&average<90) courseGrade = "良好";
		else if (average>=70&&average<80) courseGrade = "一般";
		else if (average>=60&&average<70) courseGrade = "及格";
		else courseGrade = "不及格";
	}
}















