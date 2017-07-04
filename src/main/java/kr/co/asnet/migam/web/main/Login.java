package kr.co.asnet.migam.web.main;

import java.util.*;
import javax.servlet.http.*;

public class Login implements HttpSessionBindingListener{

    private static Login Login = null;

    private static Hashtable loginUsers = new Hashtable();

    public static synchronized Login getInstance(){
        if(Login == null){
            Login = new Login();
        }
        return Login;
    }


    public void valueBound(HttpSessionBindingEvent event) {
        loginUsers.put(event.getSession(), event.getName());
     }


     public void valueUnbound(HttpSessionBindingEvent event) {
         loginUsers.remove(event.getSession());
     }


     public void removeSession(String userId){
          Enumeration e = loginUsers.keys();
          HttpSession session = null;
          while(e.hasMoreElements()){
               session = (HttpSession)e.nextElement();
               if(loginUsers.get(session).equals(userId)){
                    //session.removeAttribute(userId);
                    session.invalidate();
               }
          }
     }


    public boolean isValid(String userId, String userPw){

         return true;
    }
    
    public boolean isUsing(String userID){    
        return loginUsers.containsValue(userID);                                                                                                                                                                           
    }                                                                                                                                                                                                                      
                                                                                                                                                                                                                           
                                                                                                                                                                                                                           
                                                                                                                                                                                                                           
    public void setSession(HttpSession session, String userId){  
    	//session.invalidate();
        session.setAttribute(userId, this);                                                                                                                                                                                
    }
    
    public void setSession2(HttpSession session, String userId){  
    	session.invalidate();
        session.setAttribute(userId, this);                                                                                                                                                                                
    }   
                                                                                                                                                                                                                           
    public String getUserID(HttpSession session){                                                                                                                                                                          
        return (String)loginUsers.get(session);                                                                                                                                                                            
    }                                                                                                                                                                                                                      
                                                                                                                                                                                                                           
                                                                                                                                                                                                                           
    public int getUserCount(){                                                                                                                                                                                             
        return loginUsers.size();                                                                                                                                                                                          
    }                                                                                                                                                                                                                      
                                                                                                                                                                                                                           
                                                                                                                                                                                                                           
    public void printloginUsers(){                                                                                                                                                                                         
        Enumeration e = loginUsers.keys();                                                                                                                                                                                 
        HttpSession session = null;                                                                                                                                                     
        int i = 0;                                                                                                                                                                                                         
        while(e.hasMoreElements()){                                                                                                                                                                                        
            session = (HttpSession)e.nextElement();                                                                                                                                                                        
            System.out.println((++i) + ". id : " +  loginUsers.get(session));                                                                                                                                              
        }                                                                                                                                                     
     }                                                                                                                                                                                                                     
                                                                                                                                                                                                                           
    public Collection getUsers(){                                                                                                                                                                                          
        Collection collection = loginUsers.values();                                                                                                                                                                       
        return collection;                                                                                                                                                                                                 
    }                                                                                                                                                                                                                      
}       
    
