/** @文件名: InitSpringBeanFactory.java @创建人：邢健  @创建日期： 2015年8月1日 下午6:12:36 */
package com.promise.hardcode;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**  
 * @类名: InitSpringBeanFactory.java
 * @包名: com.promise.hardcode
 * @描述: TODO
 * @作者: xingjian xingjian@yeah.net  
 * @日期:2015年8月1日 下午6:12:36
 * @版本: V1.0  
 */
public class InitSpringBeanFactory {

	public Object getBean(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext*.xml");
		DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory)                 
		applicationContext.getBeanFactory();
		GenericBeanDefinition messageSourceDefinition = new GenericBeanDefinition();
		Map<String , String> original = new HashMap<String, String>();
		  original.put("name", "xingjianspring");
		  original.put("id", "abcdefghijklmnopqrstuvwxyz");
		  messageSourceDefinition.setBeanClass(HardCodeService.class);
		  messageSourceDefinition.setPropertyValues(new MutablePropertyValues(original));
		  //注册
		  beanFactory.registerBeanDefinition("HardCodeService", messageSourceDefinition);
		  //获取
		  HardCodeService hardCodeService = (HardCodeService) applicationContext .getBean("HardCodeService");
		  return hardCodeService;
	}
}
