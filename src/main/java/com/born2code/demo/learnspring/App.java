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
    	Parrot bird = (Parrot) context.getBean("parrot");
    	bird.speak();
    	((ClassPathXmlApplicationContext) context).close();
    }
}
