package com.born2code.demo.learnspring;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/born2code/demo/learnspring/beans/beans.xml");
		NoticesDAO noticesDao = (NoticesDAO) context.getBean("noticesDao");

		try {
			// System.out.println(noticesDao.delete(3) ? "Deleted ID: 3
			// Successfully!" : "Sorry! Cannot delete");

    		Notice notice1 = new Notice(6, "Bobby4", "bobby1@livingoncodes.com", "Late fees will be imposed!");
    		Notice notice2 = new Notice(8, "Bobby2", "bobby2@livingoncodes.com", "Late fees will be imposed!");
    		Notice notice3 = new Notice(7, "Bobby5", "bobby3@livingoncodes.com", "Late fees will be imposed!");
    		
    		List<Notice> noticeList = new ArrayList<Notice>();
    		
    		noticeList.add(notice1);
    		noticeList.add(notice2);
    		noticeList.add(notice3);
    		
    		
    		noticesDao.create(noticeList);
    		    		
        	List<Notice> notices = noticesDao.getNotices();
        	
        	for(Notice notice: notices) {
        		System.out.println(notice);
        	}

//			Notice notice = noticesDao.getNotice(6);
//			System.out.println("Notice ID: 6 -- " + notice);
		} catch (CannotGetJdbcConnectionException ex) {
			System.out.println("Could not get JDBC connection.");
		} catch (DataAccessException ex) {
			System.out.println(ex.getMessage());
			System.out.println(ex.getClass());
		}

		((ClassPathXmlApplicationContext) context).close();
	}
}
