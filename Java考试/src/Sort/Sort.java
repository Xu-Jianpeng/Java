package Sort;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Sort
{
	double []num;
	Scanner scanner;
	
	public Sort()
	{
		num=new double[11];
		num[0]=0;
		for(int i=1;i<num.length;i++)
		{
			num[i]=(double)(Math.random()*10);
		}
		SortMethod sm=new SortMethod();
		
		sm.bubbleSort(num);
		
		/*System.out.println("�����Ľ���ǣ�");
		for(int i=1;i<num.length;i++)
		{
			System.out.println(num[i]+" ");
		}*/
		
			FileWriter fileWriter = null;
			try {
				fileWriter = new FileWriter("D:/a.txt");//�����ı��ļ�
				int j=0;
				while(num!=null){//ѭ��д��
					
					fileWriter.write(num[j]+"\r\n");//д�� \r\n����
					j++;
				}
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
	
	public static void main(String args[])
	{
		Sort sort=new Sort();
		System.exit(0);
	}
}

class SortMethod
{
	//��������
	/*public void insertSort(double []a)
	{
		int i,j;
		
		for(i=2;i<a.length;i++)
		{
			a[0]=a[i];
			for(j=i-1;a[0]<a[j]&&j>=0;j--)
			{
				a[j+1]=a[j];
			}
			a[j+1]=a[0];
		}
	}*/
	
	//ð������
	public void bubbleSort(double []a)
	{
		double temp;
		int i,j;
		for(i=0;i<a.length;i++)
		{
			for(j=0;j<a.length-i-1;j++)
			{
				if(a[j]>a[j+1])
				{
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
	}
}
