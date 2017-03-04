/** @文件名: HardCodeTest.java @创建人：邢健  @创建日期： 2015年8月1日 下午6:17:58 */
package com.promise.hardcode;

import junit.framework.Assert;

import org.junit.Test;

/**  
 * @类名: HardCodeTest.java
 * @包名: com.promise.hardcode
 * @描述: TODO
 * @作者: xingjian xingjian@yeah.net  
 * @日期:2015年8月1日 下午6:17:58
 * @版本: V1.0  
 */
public class HardCodeTest {

	
	@Test
	public void testGetBean(){
		InitSpringBeanFactory isfb = new InitSpringBeanFactory();
		HardCodeService hcs = (HardCodeService)isfb.getBean();
		Assert.assertEquals(hcs.getName(), "xingjianspring");
		System.out.println(hcs.getNameId());
		System.out.println(HardCodeService.class.getClassLoader().getClass().getName());
	}
	
}
