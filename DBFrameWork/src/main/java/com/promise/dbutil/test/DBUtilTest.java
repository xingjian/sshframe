package com.promise.dbutil.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.promise.dbutil.service.JdbcPersistenceManager;
import com.promise.dbutil.service.PersistenceManager;
import com.promise.dbutil.service.QueryManager;


/**  
 * 功能描述: 环境测试
 * @author:<a href="mailto:xingjian@yeah.net">邢健</a>  
 * @version: V1.0
 * 日期:2017年3月6日 下午1:42:56  
 */
public class DBUtilTest {

	private PersistenceManager pm;
	private QueryManager qm;
	private JdbcPersistenceManager jpm;
	
	@Before
	public void initSpringService(){
		ApplicationContext ac = new FileSystemXmlApplicationContext("classpath:applicationContext*.xml");
		pm = (PersistenceManager)ac.getBean("persistenceManager");
		qm = (QueryManager)ac.getBean("queryManager");
		jpm = (JdbcPersistenceManager)ac.getBean("jdbcPersistenceManager");
	}
	
	@Test
	public void testPM(){
		System.out.println(pm.toString());
		System.out.println(qm.toString());
		System.out.println(jpm.toString());
	}
	
}
