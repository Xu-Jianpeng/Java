package Lab_4_5;


import java.io.*;
import java.util.zip.*;
public class Release {
	public static void main (String[] args) throws  IOException {
		ZipInputStream zipinput=new ZipInputStream (new FileInputStream("dest.zip")) ;
		zipinput. getNextEntry();
		DataInputStream input= new DataInputStream(zipinput);
		DataOutputStream output=new DataOutputStream(new FileOutputStream ("source1.txt"));
		int ch;
		while((ch=input.read()) !=-1){
			output. write(ch);
		}
		output.close();
		input.close();
	}
}

