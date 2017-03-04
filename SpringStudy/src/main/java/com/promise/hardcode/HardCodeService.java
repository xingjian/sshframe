/** @文件名: HardCodeService.java @创建人：邢健  @创建日期： 2015年8月1日 下午6:10:20 */
package com.promise.hardcode;

/**  
 * @类名: HardCodeService.java
 * @包名: com.promise.hardcode
 * @描述: TODO
 * @作者: xingjian xingjian@yeah.net  
 * @日期:2015年8月1日 下午6:10:20
 * @版本: V1.0  
 */
public class HardCodeService {
	private String name;
	private String id;
	
	
	public String getNameId(){
		return name + id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
	
}
