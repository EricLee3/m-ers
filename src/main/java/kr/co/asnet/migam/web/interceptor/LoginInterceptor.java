package kr.co.asnet.migam.web.interceptor;

import java.net.URLEncoder;
import java.util.Properties;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.asnet.migam.domain.user.SessionUser;
import kr.co.asnet.migam.domain.user.User;
import kr.co.asnet.migam.web.main.Login;

public class LoginInterceptor extends HandlerInterceptorAdapter {
   protected final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

   @Resource(name = "appProp")
	private Properties appProp; // vxml_url     = ems_prop.getProperty("pvsvxml.url"); 프로퍼티에서 일케 가져와도 대여.
	
   
   @Inject
   private Provider<SessionUser> userProvider;

   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      SessionUser sessionUser = userProvider.get();
      String requestURL = request.getRequestURL().toString();
      boolean demo= false;
      
      String http     = appProp.getProperty("http.port");
      String https     = appProp.getProperty("https.port");
      
      //if(!requestURL.contains("https") && !requestURL.contains(https)){
         if(requestURL.contains("system/voiceCream_demo") ||  requestURL.contains("system/reqMent") || 
               requestURL.contains("system/sens_resultCnt") || requestURL.contains("system/sens_failcode") || 
               requestURL.contains("system/voiceCream_demo_act") || 
               requestURL.contains("system/linegraph") || 
               requestURL.contains("system/circle") || 
               requestURL.contains("system/sens_failcode") || 
               requestURL.contains("system/demo_excel") || 
               requestURL.contains("system/demo_excel_act")) {
            demo = true;
         }
         /*
         else if(requestURL.contains(https+"/main")){
        	 System.out.println("main:::"+https);
            String rtUrl = URLEncoder.encode(requestURL, "utf-8");
            response.sendRedirect("/login?rtUrl=" + rtUrl);
            return false;::::::saveUser:::::::
         }
         */
    //  }
      
      Login login = Login.getInstance();
      String userRole = null;
      /* 세션 생성 */
      if (sessionUser.getCurrentUser() == null) {
         sessionUser.logoutSessionUser();
         sessionUser.saveUser(new User());
      } else {
         userRole = sessionUser.getCurrentUser().getRole(); 
      }

      String[] adminPath = {"/monitor", "/report", "/service", "/main"};
      if (StringUtils.containsAny(requestURL, adminPath)) {
         if ( !sessionUser.isLogin() ) {
            String rtUrl = URLEncoder.encode(requestURL, "utf-8");
            response.sendRedirect("/session_out");
            return false;
         }else {
            
         }
      }

      /*if (StringUtils.contains(requestURL, "/system")) {
         if ( !sessionUser.isSuperUser() && demo != true ) {
            sessionUser.logoutSessionUser();
            sessionUser.saveUser(new User());
            String rtUrl = URLEncoder.encode(requestURL, "utf-8");
            response.sendRedirect("/login?rtUrl=" + rtUrl);
            return false;
         }
      }*/
      
      if (StringUtils.contains(requestURL, "/system")) {
         if (demo == true) {
            return true;
         }else if ( !sessionUser.isSuperUser()) {
            sessionUser.logoutSessionUser();
            sessionUser.saveUser(new User());
            String rtUrl = URLEncoder.encode(requestURL, "utf-8");
            response.sendRedirect("/session_out");
            return false;
         }
      }
      
      return true;
   }
}