package kr.co.asnet.migam.utils;

import java.io.*;
import java.lang.ProcessBuilder.Redirect;

public class ShellExecute {
	public void byProcessBuilderRedirect(String[] command) throws IOException, InterruptedException {
	    ProcessBuilder builder = new ProcessBuilder(command); 
	    builder.redirectOutput(Redirect.INHERIT);
	    builder.redirectError(Redirect.INHERIT);
	    builder.start();
	}
   
   public String execute(String category) {
       String s="";

       try {
         /*  자바 1.4 이하에서는 이렇게
         Runtime oRuntime = Runtime.getRuntime();
         Process oProcess = oRuntime.exec("cmd /c dir /?");
         */

	   	// 자바 1.5 이상에서는 이렇게 1줄로
    	//Process oProcess = new ProcessBuilder("cmd", "c:\\", "dir", "/?").start();
       //Process oProcess = new ProcessBuilder(command).start();	
    	   System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk::::::::::::::::::::::::::");
    	 //Process oProcess = new ProcessBuilder("python ", "c:\\home\\mecs\\script\\chkpid.py ", "kill ", category).start();
    	 Process oProcess = new ProcessBuilder("cmd", "/C", "python c:\\home\\mecs\\script\\chkpid.py kill "+category).start();
    	 
    	 
    	 
    	  // Process oProcess = new ProcessBuilder("type ", "NUL", " > ", "C:\\EmptyFile.txt").start();
    	   //Process oProcess = new ProcessBuilder("cmd", "taskkill", "/f", "/pid ", category).start();
    	   System.out.println("oProcessoProcessoProcess:::::::::::::" + oProcess.toString());
         // 외부 프로그램 출력 읽기
         BufferedReader stdOut   = new BufferedReader(new InputStreamReader(oProcess.getInputStream()));
         BufferedReader stdError = new BufferedReader(new InputStreamReader(oProcess.getErrorStream()));
         
         System.out.println("stdOut:::::::::::::::::::::::::::::::::::::::::::" + stdOut.toString());
         System.out.println("stdError:::::::::::::::::::::::::::::::::::::::::::::" + stdError.toString());
         // "표준 출력"과 "표준 에러 출력"을 출력
 //        while ((s =   stdOut.readLine()) != null) System.out.println(s);
//         while ((s = stdError.readLine()) != null) System.err.println(s);
//         System.out.println("s:::::::::::::::::::::::::::::::::::::::::::::" + s.toString());
         // 외부 프로그램 반환값 출력 (이 부분은 필수가 아님)
//         System.out.println("Exit Code:::::::::::::::::::::::::::: " + oProcess.exitValue());
 //        System.exit(oProcess.exitValue()); // 외부 프로그램의 반환값을, 이 자바 프로그램 자체의 반환값으로 삼기 
         System.out.println("1111111111::::::::::::::::::::::::");

       } catch (IOException e) { // 에러 처리
           System.err.println("에러! 외부 명령 실행에 실패했습니다.\n" + e.getMessage());
           System.exit(-1);
         }
       System.out.println("2222222222::::::::::::::::::::::::");
        return s.toString();
    }
   
   public String execute2(String category) {
       String s="";

       try {
         /*  자바 1.4 이하에서는 이렇게
         Runtime oRuntime = Runtime.getRuntime();
         Process oProcess = oRuntime.exec("cmd /c dir /?");
         */

	   	// 자바 1.5 이상에서는 이렇게 1줄로
    	//Process oProcess = new ProcessBuilder("cmd", "c:\\", "dir", "/?").start();
       //Process oProcess = new ProcessBuilder(command).start();	
    	   Process oProcess = new ProcessBuilder("cmd", "PowerShell", "-NoProfile", "-ExecutionPolicy", "unrestricted", "-Command", "c:\\home\\mecs\\script\\hideproc c:\\home\\mecs\\"+category+"\\bin\\",category,".exe", "''").start();
    	   System.out.println("oProcessoProcessoProcess:::::::::::::" + oProcess.toString());
         // 외부 프로그램 출력 읽기
         BufferedReader stdOut   = new BufferedReader(new InputStreamReader(oProcess.getInputStream()));
         BufferedReader stdError = new BufferedReader(new InputStreamReader(oProcess.getErrorStream()));
         
         System.out.println("stdOut:::::::::::::::::::::::::::::::::::::::::::" + stdOut.toString());
         System.out.println("stdError:::::::::::::::::::::::::::::::::::::::::::::" + stdError.toString());
         // "표준 출력"과 "표준 에러 출력"을 출력
 //        while ((s =   stdOut.readLine()) != null) System.out.println(s);
//         while ((s = stdError.readLine()) != null) System.err.println(s);
//         System.out.println("s:::::::::::::::::::::::::::::::::::::::::::::" + s.toString());
         // 외부 프로그램 반환값 출력 (이 부분은 필수가 아님)
//         System.out.println("Exit Code:::::::::::::::::::::::::::: " + oProcess.exitValue());
//         System.exit(oProcess.exitValue()); // 외부 프로그램의 반환값을, 이 자바 프로그램 자체의 반환값으로 삼기 
         System.out.println("1111111111::::::::::::::::::::::::");

       } catch (IOException e) { // 에러 처리
           System.err.println("에러! 외부 명령 실행에 실패했습니다.\n" + e.getMessage());
           System.exit(-1);
         }
       System.out.println("2222222222::::::::::::::::::::::::");
        return s.toString();
    }
   
/*
   public static void main(String[] args) {
      execute("C:\\Program Files (x86)\\SQLyog\\SQLyog.exe");
   
   }
   */
}