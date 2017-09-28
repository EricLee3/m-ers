import java.io.*;
import java.lang.*;
import java.lang.ProcessBuilder.Redirect;

// commented by IOS [20170614]
//import org.apache.commons.exec.DefaultExecutor;


public class aa {

	public static void byProcessBuilderRedirect(String[] command)  
	        throws IOException, InterruptedException {
	    ProcessBuilder builder = new ProcessBuilder(command); 
	    builder.redirectOutput(Redirect.INHERIT);
	    builder.redirectError(Redirect.INHERIT);
	    builder.start();
	}
	
   public static void main(String[] args) {
	   //String[] a ={"cmd", "/c", "taskkill /F /IM 12628"}; 
	    //String[] a ={"cmd", "/c", "tasklist"}; 
	   String category = "CDRP";
		String[] a = {"bash", "/c", "BOT-MECS CDRP"};
	   try {
		byProcessBuilderRedirect(a);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }

}
