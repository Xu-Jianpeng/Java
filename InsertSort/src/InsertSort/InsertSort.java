package InsertSort;

import java.util.Scanner;
public class InsertSort{
	double num[];
	Scanner scanner;

	public InsertSort(){
		num = new double[11];
		scanner=new Scanner(System.in);
		num[0]=0;
		System.out.println("请输入十个数字：");
		for(int i=1;i<num.length;i++){
			num[i]=scanner.nextDouble();
		}

		directSort(num);

		System.out.println("排序后的结果是:");
		for(int i=1;i<num.length;i++){
			System.out.print(num[i]+"	");
		}
	}

		public void directSort(double n[]){
			int i,j;
			for(i=2;i<n.length;i++){
				n[0]=n[i];
				for(j=i-1;n[0]<n[j]&&j>0;j--)
					n[j+1]=n[j];
				n[j+1]=n[0];
			}
		}

		public static void main(String arg[]){
			InsertSort insertSort=new InsertSort();
			System.exit(0);
		}
}

