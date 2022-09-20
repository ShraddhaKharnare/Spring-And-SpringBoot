package com.cg.springioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Mobile
{
  @SuppressWarnings("resource")
public static void main(String []args)
  {
	/*obj creating for Airtel
	  Sim s=new Airtel();
	  s.calling();
	  s.data();
	  
	  //obj creating for Jio
	  Sim s1=new Jio(); 
	  s1.calling();
	  s1.data(); */
  
	  ApplicationContext a=new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("Config...loaded!");
		
		//using IOC
		Sim obj=a.getBean("sim",Sim.class);
		obj.calling();
		obj.data();
		
		/*Jio obj1=(Jio)a.getBean("jio");// use for jio <bean id="sim" class="com.cg.springioc.Jio"></bean>
		obj1.calling();
		obj1.data();*/
		
		/*Airtel obj2=(Airtel)a.getBean("Airtel");
		obj2.calling();
		obj2.data();*/
  
  }
}
