package Lab_4_5;


import java.io.*;
import java.util.zip.*;
public class Compress {
	public static void main (String[] args) throws  IOException {
		DataInputStream input=new DataInputStream (new FileInputStream("source.txt")) ;
		ZipOutputStream zipoutput=new ZipOutputStream (new FileOutputStream("dest.zip")) ;
		zipoutput.setMethod(ZipOutputStream.DEFLATED);
		zipoutput.putNextEntry(new ZipEntry("source.txt"));
		DataOutputStream output=new DataOutputStream(zipoutput);
		int ch;
		while((ch=input.read()) !=-1){
			output. write(ch);
		}
		output.close();
		input.close();
	}
}


