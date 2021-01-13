package student;
import java.io.*;
import java.util.*;
import javax.swing.*;
public class ScoreSort2{
	int number=100;
	Student student[];
	File filename;
	
	public ScoreSort2(){
		output();
		student=new Student[number];
		student=readFromFile();
		sort(student);
		System.err.println("排序后：");
		writeToFile(student);
		output();
	}
	
	public void output()
	{
		try {
  			ObjectInputStream input= new ObjectInputStream(new FileInputStream("student.dat"));
  			System.out.println("输出文件student.dat的内容");
  			Student[] stu=(Student [])input.readObject();
  			for(int i=0;i<stu.length;i++)
  				System.out.println(stu[i].getId()+" "+stu[i].getName()+' '+stu[i].getScore());
  			input.close();
  		}
  		catch(IOException ex) {
  			System.err.println("打开文件失败");
  		}
  		catch(ClassNotFoundException ex) {	
  		}
	}
	public void sort(Student s[]){
		for(int i=1;i<s.length;i++)
			for(int j=0;j<s.length-i;j++) 
				if(s[j].score<s[j+1].score) {
					Student t=s[j];
					s[j]=s[j+1];
					s[j+1]=t;
		}
	}
	public Student[] readFromFile(){
		Student s[]=null;
		try{
			ObjectInputStream input= new ObjectInputStream(new FileInputStream("student.dat"));
  			s=(Student[])input.readObject();
		}
		catch(IOException ex){
			System.err.println("ERROR");
		}
		catch(ClassNotFoundException ex){
			
		}
		return s;
	}
	
	public void writeToFile(Student[] s){
		try{
			ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream("student.dat"));
			output.writeObject(s);
			output.close();
		}catch(IOException ex){
			JOptionPane.showMessageDialog(null,"读入文件失败！");
		}
	}
	
	public static void main(String[] args) {
		ScoreSort2 scoresort = new ScoreSort2();
		System.exit(0);
	}
}

