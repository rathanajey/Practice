import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TimeConversion {

	public static void main(String args[]){
		Scanner in=new Scanner(System.in).useDelimiter(":");
		int hours=in.nextInt();
		int minutes=in.nextInt();
		String secondsAP=in.next();
		if(secondsAP.charAt(2)=='P'&& hours!=12) hours+=12;
		String newSecs=secondsAP.substring(0, 2);
		String sHours="", sMins="", sSecs="";
		sHours=String.valueOf(hours);
		sMins=String.valueOf(minutes);
		if(hours<10) sHours=String.format("%02d", hours);
		if(minutes<10) sMins=String.format("%02d", minutes);		
		System.out.println(sHours+":"+sMins+":"+newSecs);
	}
	
}
