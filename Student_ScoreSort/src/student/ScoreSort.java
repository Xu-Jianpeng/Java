package student;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
public class ScoreSort {
	Scanner scanner;
	Student[] student;
	int number;
	File filename;
	
	public ScoreSort(){
		scanner=new Scanner(System.in);
		System.out.print("����ѧ���ĸ�����");
		number = scanner.nextInt();
		try{
			if(number<=0) throw new NegativeException();
			input(number);
			writeToFile(student);
		}catch(NegativeException e){
			JOptionPane.showMessageDialog(null,"����С��1��");
		}
	}
	public void input (int n){
		student=new Student[n];
		System.out.println("ѧ��	����	�ɼ�");
			for(int i=0;i<student.length;i++){
				int id=scanner.nextInt();
				String name=scanner.next();
				int score=scanner.nextInt();
				student[i]=new Student(id,name,score);
			}
	  }
	
	  	public void writeToFile(Student[] s){
	  		try{
	  			ObjectOutputStream output=new ObjectOutputStream(new FileOutputStream("student.dat"));
	  			for(int i=0;i<s.length;i++) {
	  				output.writeObject(s);
	  				output.writeObject(s);
	  				output.writeObject(s);
	  			}
  				output.close();
	  		}catch(IOException ex){
	  			JOptionPane.showMessageDialog(null,"�����ļ�ʧ�ܣ�");
	  		}
	  	}
	
	  	public static void main(String[] args){
	  		ScoreSort scoresort = new ScoreSort();
	  		System.exit(0);
	  	}
	}
class NegativeException extends Exception{
	NegativeException(){
	}
	public String toString(){
		return "������С�ڻ����0";
	}
}

