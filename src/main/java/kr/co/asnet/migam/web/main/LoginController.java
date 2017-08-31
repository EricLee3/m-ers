package kr.co.asnet.migam.web.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.co.asnet.migam.domain.PageDTO;
import kr.co.asnet.migam.domain.SearchDTO;
import kr.co.asnet.migam.domain.agent.Agent;
import kr.co.asnet.migam.domain.call.AgentCall;
import kr.co.asnet.migam.domain.call.CallAnalysis;
import kr.co.asnet.migam.domain.call.CallAudit;
import kr.co.asnet.migam.domain.call.DailyCall;
import kr.co.asnet.migam.domain.config.Parameter;
import kr.co.asnet.migam.domain.user.User;
import kr.co.asnet.migam.service.agent.AgentService;
import kr.co.asnet.migam.service.call.AgentCallService; 
import kr.co.asnet.migam.service.call.CallAnalysisService;
import kr.co.asnet.migam.service.call.CallAuditService;
import kr.co.asnet.migam.service.call.DailyCallService;
import kr.co.asnet.migam.service.config.ParameterService;
import kr.co.asnet.migam.service.user.UserService;
/**
 * 로그인 컨트롤러
 * 
 * @author kwonsy
 * 
 */
@Controller
public class LoginController {
	private final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Inject
	private UserService userService;
	
	/*
	 * 로그인 페이지
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login( Model model, SearchDTO searchDTO) {
		return "/main/login";
	}

	/*
	 * 로그인 처리
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginForm( User user, Model model, HttpServletRequest request, HttpServletResponse response) {
		int status = 0;
		Login login = Login.getInstance();
		HttpSession session = request.getSession(false); 
	     
	     if(session != null){  
	      session.invalidate();  
	     }
	     
	     session = request.getSession(true); 
		login.printloginUsers();
		status = userService.login(user);
		 if(login.isUsing(user.getUserId())){
			 /*
	        	session.setAttribute("login", "1");
	        	model.addAttribute("login", (String)session.getAttribute("login"));
	        	*/
	        	login.removeSession(user.getUserId());
	        	status = userService.login(user);
	        	login.setSession(session, user.getUserId());
	        	userService.updateUserTime(user);
	        	
	        	session.setAttribute("login", "2");
	        	session.setAttribute("login_id", user.getUserId());
	        	model.addAttribute("login", (String)session.getAttribute("login"));
	        
				Calendar calendar = Calendar.getInstance();
		        java.util.Date date = calendar.getTime();
		        String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
		        
				session.setAttribute("a_flag", "1");
				session.setAttribute("a_date", today);
				model.addAttribute("a_flag", (String)session.getAttribute("a_flag"));
				model.addAttribute("a_date", (String)session.getAttribute("a_date"));
			    		return ("redirect:/main");
	        }else {
				if ( status == 1 ) {
				        	login.setSession(session, user.getUserId());
				        	
				        	userService.updateUserTime(user);
				        	
				        	session.setAttribute("login", "2");
				        	session.setAttribute("login_id", user.getUserId());
				        	model.addAttribute("login", (String)session.getAttribute("login"));
				        
					Calendar calendar = Calendar.getInstance();
		            java.util.Date date = calendar.getTime();
		            String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
		            
					session.setAttribute("a_flag", "1");
					session.setAttribute("a_date", today);
					model.addAttribute("a_flag", (String)session.getAttribute("a_flag"));
					model.addAttribute("a_date", (String)session.getAttribute("a_date"));
					return ("redirect:/main");
		}
		return ("redirect:/login");
	        }
	}

	
	/*
	 * 로그인 페이지
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout( Model model, HttpServletRequest request, HttpServletResponse response,User user) {
		Login login = Login.getInstance();
		//login.removeSession(user.getUserId());
		userService.logout();
		Calendar calendar = Calendar.getInstance();
        java.util.Date date = calendar.getTime();
        String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
		/*
		HttpSession session = request.getSession();
		session.setAttribute("a_flag", "1");
		session.setAttribute("a_date", "");
		*/
		return ("redirect:/login");
	}
	
	@RequestMapping(value = "/session_out", method = RequestMethod.GET)
	public String session_out( Model model, HttpServletRequest request, HttpServletResponse response,User user) {
		Login login = Login.getInstance();
		//login.removeSession(user.getUserId());
		userService.logout();
		Calendar calendar = Calendar.getInstance();
        java.util.Date date = calendar.getTime();
        String today = (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
		/*
		HttpSession session = request.getSession();
		session.setAttribute("a_flag", "1");
		session.setAttribute("a_date", "");
		*/
		return "main/session_out";
	}
	
	/**
	 * 404 에러 페이지
	 * 
	 * @return
	 */
	@RequestMapping(value = "/error404", method = RequestMethod.GET)
	public String error404() {
		return "error/error404";
	}

	
}
