package com.born2code.demo.learnspring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("com/born2code/demo/learnspring/beans/beans.xml");
    	Patient patient = (Patient) context.getBean("patient");
    	System.out.println(patient);
    	for( EmergencyContact contact : patient.getEmergencyContact()){
    		System.out.println(contact);
    	}
    	((ClassPathXmlApplicationContext) context).close();
    }
}
