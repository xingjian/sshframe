/*@文件名: HibernateUtil.java  @创建人: 邢健   @创建日期: 2011-9-9 上午10:57:16*/
package com.promise.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**   
 * @类名: HibernateUtil.java 
 * @包名: com.promise.hibernate 
 * @描述: hibernate帮助类 
 * @作者: 邢健 xingjian@yeah.net   
 * @日期: 2011-9-9 上午10:57:16 
 * @版本 V1.0   
 */
public class HibernateUtil {

	private Configuration configuration;//配置类
	
	public SessionFactory sessionFactory;//session工厂

	private static HibernateUtil hibernateUtil;//自身实例对象
	
	/**
	 * 单例模式
	 */
	public static HibernateUtil getInstance(){
		if(null==hibernateUtil){
			hibernateUtil = new HibernateUtil();
			hibernateUtil.buildSessionFactory();
		}
		return hibernateUtil;
	}
	
	public HibernateUtil(){
		buildSessionFactory();
	}
	
	/**
	 * 获取Configuration
	 * 默认加载classpath下的hibernate.cfg.xml
	 */
	public void initConfiguration(){
		configuration = new Configuration().configure();
	}
	
	/**
	 * 创建sessionFactory
	 */
	public void buildSessionFactory(){
		initConfiguration();
		sessionFactory = configuration.buildSessionFactory();
	}
	
}
