package Polymorphism;

abstract class Student {
	final static int CourseNo = 3;
	String name;
	String type;
	int[] courses;
	String courseGrade;
	public Student (String name) {
		this.name = name;
		courses = new int[CourseNo];
		this.courseGrade = null;
	}
	public abstract void calculateGrade();
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public String getCourseGrade() {
		return courseGrade;
	}
	public int getCourseScore(int courseNumber) {
		return courses[courseNumber];
	}
	public void setName (String name) {
		this.name = name;
	}
	public void setType (String type) {
		this.type = type;
	}
	public void setCourseScore (int courseNumber, int courseScore) {
		courses[courseNumber] = courseScore;
	}
}
