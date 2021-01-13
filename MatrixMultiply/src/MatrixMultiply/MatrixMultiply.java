package MatrixMultiply;

import java.util.Scanner;

public class MatrixMultiply {
	Scanner scanner;
	int a[][];
	int b[][];
	int c[][];
	
	public MatrixMultiply() {
		scanner = new Scanner(System.in);
		int a[][]=new int [2][3];
		int b[][]=new int [3][4];
		int c[][]=new int [2][4];
		input(a,2,3);
		input(b,3,4);
		multiply(a,b,c);
		output(c,2,4);
	}
	
	public void input(int aa[][],int row,int col) {
		System.out.println("输入数值：行数="+row+" 列数="+col);
		for(int i=0;i<row;i++)
			for(int j=0;j<col;j++)
				aa[i][j]=scanner.nextInt();
	}
	
	public void multiply(int aa[][],int bb[][],int result[][]) {
		for(int i=0;i<aa.length;i++) {
			for(int j=0;j<bb[0].length;j++) {
				for(int k=0;k<bb.length;k++){ 
					result[i][j]+=aa[i][k]*bb[k][j];
				}
			}
		}
	}
	
	public void output(int aa[][],int row,int col) {
		System.out.println("输出数组");
		for(int i=0;i<row;i++) {
			for (int j=0;j<col;j++)
				System.out.print(aa[i][j]+"  ");
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		MatrixMultiply mm=new MatrixMultiply();
		System.exit(0);
	}
}
