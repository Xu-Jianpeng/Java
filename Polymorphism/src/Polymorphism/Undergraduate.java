package Polymorphism;


class Undergraduate extends Student {
	public Undergraduate(String name) {
		super(name);
		type = "本科生";
	}
	public void calculateGrade() {
		int total = 0;
		double average = 0;
		for (int i = 0; i < CourseNo; i++) {
			total += courses[i];
		}
		average = total/CourseNo;
	
	if (average>=80&&average<100) courseGrade = "优秀";
		else if (average>=70&&average<80) courseGrade = "良好";
		else if (average>=60&&average<70) courseGrade = "一般";
		else if (average>=50&&average<60) courseGrade = "及格";
		else courseGrade = "不及格";
	}
}













