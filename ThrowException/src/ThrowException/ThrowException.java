package ThrowException;

import java.util.Random;

public class ThrowException {
	public static void result(int x,int y) throws Exception{
		double C = 0;
		double A = 4*x-4;
		double B = 2*x*x-4*x*y+y*y;
        System.out.println("A="+A+"\n"+"B="+B); 		
		try{
			if(A==0||B==0) {
				throw new ArithmeticException("AªÚB=0");
			}
			if(A!=0&&B!=0) {
				throw new Exception("problem is ok");
			}
		}
		catch (ArithmeticException e){
      		System.out.println(e.getMessage());
      	}
	  	catch (Exception e){
	  		C = A/B;
	  		System.out.println(e.getMessage());	  	
	  	}
		finally{
	        System.out.println("program is end");
		    System.out.println("C = "+C);
		}		
	}

	public static void main(String[] args) throws Exception {
		Random r= new Random();
		int x = r.nextInt(20);
		int y = r.nextInt(20);
        System.out.println("x="+x+"\n"+"y="+y); 
        result(x,y);
		
	}
}
