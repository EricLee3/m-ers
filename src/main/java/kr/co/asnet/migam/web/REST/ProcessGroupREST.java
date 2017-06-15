package kr.co.asnet.migam.web.REST;


import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.AgentGroup;
import kr.co.asnet.migam.domain.agent.FaultAlarmHisGroup;
import kr.co.asnet.migam.domain.agent.FaultAlarmLog;
import kr.co.asnet.migam.domain.agent.FaultAlarmStatGroup;
import kr.co.asnet.migam.domain.agent.HisLog;
import kr.co.asnet.migam.domain.user.User;
import kr.co.asnet.migam.service.agent.AgentGroupService;
import kr.co.asnet.migam.service.agent.AgentService;
import kr.co.asnet.migam.service.agent.AlarmCodeService;
import kr.co.asnet.migam.service.agent.ProcessGroupService; 
import kr.co.asnet.migam.utils.*;
/**
 * 상담원 그룹 관련 AJAX 호출을 처리하기 위해 사용하는 컨트롤러 클래스
 * 
 * @author kwonsy
 *
 */
@RestController
@RequestMapping(value = "/REST/processgroup")
public class ProcessGroupREST {
	private final Logger logger = LoggerFactory.getLogger(ProcessGroupREST.class);

	@Autowired
	private ProcessGroupService ProcessGroupService;
	
	/**
	 * 프로세스를 종료 하기 위한 엔드포인트입니다.
	 * @param groupId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/deleteProcess/{category}", method = RequestMethod.GET)
	public ResponseEntity<String> deleteProcess(@PathVariable("category") String category, Model model, SearchDTO searchDTO, HttpServletResponse response, HttpServletRequest request) {

		ShellExecute shellexe = new ShellExecute();
		//String isDeleted = shellexe.execute("C:\\Program Files (x86)\\SQLyog\\SQLyog.exe");
		String isDeleted ="";
		//isDeleted = shellexe.execute("python c:\\home\\mecs\\script\\chkpid.py kill "+category);
		//isDeleted = shellexe.execute(category);
		//String[] a ={"cmd", "/c", "taskkill /F /IM 9380"}; 
		
		String[] a ={"cmd", "/c", "python c:\\home\\mecs\\script\\chkpid.py kill "+category};
		Calendar calendar = Calendar.getInstance();
        java.util.Date date = calendar.getTime();
        String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
		HttpSession session = request.getSession();
		session.setAttribute("a_flag", "1");
		session.setAttribute("a_date", today);
		model.addAttribute("a_flag", (String)session.getAttribute("a_flag"));
		model.addAttribute("a_date", (String)session.getAttribute("a_date"));
		try {
			shellexe.byProcessBuilderRedirect(a);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "");
		response.setHeader("Expires", "0");
		
		if(isDeleted.equals("")) {
			return new ResponseEntity<String>(isDeleted, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		}
	}

	/**
	 * 프로세스를 시작 하기 위한 엔드포인트입니다.
	 * @param groupId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/startProcess/{category}", method = RequestMethod.GET)
	public ResponseEntity<String> startProcess(@PathVariable("category") String category, Model model, SearchDTO searchDTO, HttpServletResponse response) {
		
		ShellExecute shellexe = new ShellExecute();
		//String isDeleted = shellexe.execute("C:\\Program Files (x86)\\SQLyog\\SQLyog.exe");
		String isStarted ="";
		//isStarted = shellexe.execute("PowerShell -NoProfile -ExecutionPolicy unrestricted -Command c:\\home\\mecs\\script\\hideproc c:\\home\\mecs\\PSNR\\bin\\"+category+".exe ''");
		//isStarted = shellexe.execute2(category);
		if(category.equals("CDRP") || category.equals("BAAP") || category.equals("MOXI") || category.equals("PMON")) {
			String[] a = {"cmd", "/c", "PowerShell -NoProfile -ExecutionPolicy unrestricted -Command c:\\home\\mecs\\script\\hideproc c:\\home\\mecs\\"+category+"\\bin\\"+category+".exe '1 start'"};
			try {
				shellexe.byProcessBuilderRedirect(a);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(category.equals("LOGD")) {
			String[] b = {"cmd", "/c", "PowerShell -NoProfile -ExecutionPolicy unrestricted -Command c:\\home\\mecs\\script\\hideproc c:\\home\\mecs\\"+category+"\\bin\\"+category+".exe 'start'"};
			try {
				shellexe.byProcessBuilderRedirect(b);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(category.equals("OAMD") || category.equals("STAP") || category.equals("PSNR")) {
			String[] c = {"cmd", "/c", "PowerShell -NoProfile -ExecutionPolicy unrestricted -Command c:\\home\\mecs\\script\\hideproc c:\\home\\mecs\\"+category+"\\bin\\"+category+".exe ''"};
			try {
				shellexe.byProcessBuilderRedirect(c);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			String[] d = {"cmd", "/c", "PowerShell -NoProfile -ExecutionPolicy unrestricted -Command c:\\home\\mecs\\script\\hideproc c:\\home\\mecs\\"+category+"\\bin\\"+category+".exe './Res/config.xml'"};
			try {
				shellexe.byProcessBuilderRedirect(d);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Pragma", "");
		response.setHeader("Expires", "0");
		
        
		if(isStarted.equals("")) {
			return new ResponseEntity<String>(isStarted, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.NO_CONTENT);
		}
	}
		
		/**
		 * Fault 알람을 삭제 하기 위한 엔드포인트입니다.
		 * @param groupId
		 * @param model
		 * @return
		 */
		@RequestMapping(value = "/deleteFaultAlarm/{code}", method = RequestMethod.GET)
		public ResponseEntity<Boolean> deleteFaultAlarm(@PathVariable("code") String code, Model model, SearchDTO searchDTO, FaultAlarmLog fault, HttpServletResponse response) throws UnknownHostException {
			Boolean isDeleted = false;
			String result = "";
			String[] array;
			array = code.split(",");
			
			fault.setS_username(array[1]);
			fault.setS_userid(array[2]);
			fault.setCode(array[0]);
			
			result = ProcessGroupService.insertFaultHis(fault);
			isDeleted = ProcessGroupService.deleteFaultAlarm(array[0]); 
			
			response.setHeader("Cache-Control", "no-store");
			response.setHeader("Pragma", "");
			response.setHeader("Expires", "0");
			
			if(isDeleted) {
				return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
			} else {
				return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
			}
		}
		
		@RequestMapping(value = "/setSoundOff", method = RequestMethod.GET)
		public ResponseEntity<Boolean> setSoundOff(Model model, SearchDTO searchDTO, HttpServletRequest request, HttpServletResponse response) throws UnknownHostException {
			Boolean isDeleted = false;
			Calendar calendar = Calendar.getInstance();
            java.util.Date date = calendar.getTime();
            String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
			
			HttpSession session = request.getSession();
			session.setAttribute("a_flag", "0");
			session.setAttribute("a_date", today);
			model.addAttribute("a_flag", (String)session.getAttribute("a_flag"));
			model.addAttribute("a_date", (String)session.getAttribute("a_date"));
			
			response.setHeader("Cache-Control", "no-store");
			response.setHeader("Pragma", "");
			response.setHeader("Expires", "0");
			
			if(isDeleted) {
				return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
			} else {
				return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
			}
		}
		
		@RequestMapping(value = "/setSoundOn", method = RequestMethod.GET)
		public ResponseEntity<Boolean> setSoundOn(Model model, SearchDTO searchDTO, HttpServletRequest request, HttpServletResponse response) throws UnknownHostException {
			Boolean isDeleted = false;
			HttpSession session = request.getSession();
			
			session.setAttribute("a_flag", "1");
			model.addAttribute("a_flag", (String)session.getAttribute("a_flag"));
			
			response.setHeader("Cache-Control", "no-store");
			response.setHeader("Pragma", "");
			response.setHeader("Expires", "0");
			
			if(isDeleted) {
				return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
			} else {
				return new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT);
			}
		}
}
