//package Hello;
import java.io.*;
public class MyDataStream {
	public static void main(String[] args) {
	     try{
		DataOutputStream dos=new DataOutputStream(new BufferedOutputStream(new FileOutputStream
	("MyDataStream.txt")));
	          DataInputStream dis=new DataInputStream(new BufferedInputStream(new FileInputStream
	("MyDataStream.txt")));
	          String str="中国China";
//	          dos.writeUTF(str);    
//	          dos.writeChars(str); 
//	          dos.writeBytes(str);
	          dos.write(str.getBytes());
	          dos.close();
//	          System.out.println(dis.readUTF());
//	          char [] c=new char[7];
//	          for(int i=0;i<7;i++){     
//	              c[i]=dis.readChar();    
//	          }
//	          System.out.println(new String(c,0,7));
	          for(int i=0;i<7;i++){     
	        	  System.out.print(dis.readByte()+" ");   
	          }
	          
	     }
		 catch(Exception e){
	         e.printStackTrace();
		 }
}}
