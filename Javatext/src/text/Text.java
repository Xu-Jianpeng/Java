package text;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class Text {

		double num[];
		
		public Text()
		{
			num=new double[11];
			for(int i=1;i<num.length;i++)
			{
				num[i]=(double)(Math.random()*100);
			}
			
			/*
			System.out.println("排序前的结果是：");
			for(int i=1;i<num.length;i++)
			{
				System.out.println(num[i]+" ");
			}*/
			FileWriter fileWriter = null;
			try {
				fileWriter = new FileWriter("text.txt");//创建文本文件
				int j=1;
				while(num!=null&&j<num.length){//循环写入
					fileWriter.write(num[j]+"\r\n");//写入 \r\n换行
					j++;
				}
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			SortMethod sm=new SortMethod();
			
			sm.bubbleSort(num);
				/*FileWriter fileWriter1 = null;
				try {
					fileWriter1 = new FileWriter("text.txt",true);//写入文本文件
					int j=1;
					fileWriter.write("\r\n");//写入 \r\n换行
					while(num!=null&&j<num.length){//循环写入
						fileWriter.write(num[j]+"\r\n");//写入 \r\n换行
						j++;
					}
					fileWriter.flush();
					fileWriter.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			try { 
	             //追加 
				FileWriter fw = new FileWriter("text.txt",true); 
				PrintWriter out = new PrintWriter(fw); 
				int j=0;
				while(num!=null&&j<10){
					out.println(num[j]+"\r\n"); 
					j++;
				}
				out.close(); 
				fw.close(); 
			} catch (IOException e) { 
				e.printStackTrace(); 
			} 
			
		}
		
		public static void main(String args[])
		{
			Text text=new Text();
			System.exit(0);
		}
	}

	class SortMethod
	{
		
		//冒泡排序
		public void bubbleSort(double []a)
		{
			double temp;
			int i,j;
			for(i=0;i<a.length;i++)
			{
				for(j=0;j<a.length-i-1;j++)
				{
					if(a[j]<a[j+1])
					{
						temp=a[j];
						a[j]=a[j+1];
						a[j+1]=temp;
					}
				}
			}
		}
}
