package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeComtroller 
{
   @RequestMapping("admin")
   private String print(HttpServletRequest req,HttpServletResponse res)
   {
	   HttpSession s=req.getSession();
	   String TNS=req.getParameter("TNS");
	   System.out.println("Print Hi" +TNS);
	   s.setAttribute("TNS",TNS);
	   System.out.println("Hey Folks, Todat is celebration of 10th Anniversary"
                       + "of TNS India Foundation");
       return "home.jsp";
   }
}
