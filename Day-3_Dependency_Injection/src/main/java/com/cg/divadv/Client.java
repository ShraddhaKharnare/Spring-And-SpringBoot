package com.cg.divadv;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client
{

		@SuppressWarnings("resource")
		public static void main(String[] args) {
			ApplicationContext c=new ClassPathXmlApplicationContext("beans.xml");
			Student_New s=c.getBean("s",Student_New.class);
			s.cheating();
	}

}
